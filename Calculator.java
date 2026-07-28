import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculator.java
 * ------------------------------------------------------
 * A simple console-based calculator built with Core Java.
 *
 * Features:
 *  - Menu-driven interface (Addition, Subtraction, Multiplication, Division, Exit)
 *  - Input validation (rejects non-numeric input without crashing)
 *  - Handles division by zero gracefully
 *  - Runs in a loop until the user chooses to exit
 *
 * Author : <Your Name>
 * Purpose: Java Programming Internship - Task 1 (Simple Calculator)
 * ------------------------------------------------------
 */
public class Calculator {

    // Scanner is declared once at the class level and reused everywhere,
    // instead of creating a new Scanner object every time we need input.
    // Creating multiple Scanner objects on System.in can cause resource
    // leaks / unexpected input issues, so one shared instance is best practice.
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * main() is the entry point of the program.
     * It shows the menu in a loop, reads the user's choice,
     * and calls the correct method based on that choice.
     */
    public static void main(String[] args) {

        boolean continueProgram = true; // controls whether the menu loop keeps running

        System.out.println("=================================================");
        System.out.println("        WELCOME TO THE JAVA CONSOLE CALCULATOR   ");
        System.out.println("=================================================");

        // The main program loop. It keeps showing the menu
        // until the user selects the "Exit" option.
        while (continueProgram) {

            printMenu();                     // Step 1: show options
            int choice = readMenuChoice();   // Step 2: safely read the user's menu choice

            // Option 5 (Exit) is handled separately because it does not need two numbers.
            if (choice == 5) {
                System.out.println("\nThank you for using the Java Calculator. Goodbye!");
                continueProgram = false; // this will end the while loop
                continue;                // skip the rest of this iteration
            }

            // For options 1-4 we need two numbers from the user.
            // readDouble() makes sure the input is a valid number before proceeding.
            double num1 = readDouble("Enter the first number  : ");
            double num2 = readDouble("Enter the second number : ");

            double result = 0;      // will hold the outcome of the calculation
            boolean success = true; // becomes false only if division by zero happens

            // switch-case decides which operation to perform based on the menu choice.
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    // Division needs special handling because dividing by zero
                    // is mathematically undefined and would normally crash the program.
                    if (num2 == 0) {
                        System.out.println("\nError: Division by zero is not allowed. Please try again.");
                        success = false;
                    } else {
                        result = divide(num1, num2);
                    }
                    break;
                default:
                    // This should not normally happen because readMenuChoice()
                    // already restricts the value to 1-5, but it is kept as a safety net.
                    System.out.println("\nInvalid choice. Please select a valid option from the menu.");
                    success = false;
            }

            // Only print the result if the operation actually completed successfully.
            if (success) {
                printResult(choice, num1, num2, result);
            }

            System.out.println(); // blank line for readability before the next loop
        }

        scanner.close(); // release the Scanner resource before the program ends
    }

    /**
     * Prints the operation menu to the console.
     */
    private static void printMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("Please choose an operation:");
        System.out.println("1. Addition       (+)");
        System.out.println("2. Subtraction    (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division       (/)");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Safely reads the user's menu choice.
     * Keeps asking until the user enters an integer between 1 and 5.
     * This prevents the program from crashing on invalid input
     * (e.g., letters, symbols, or out-of-range numbers).
     */
    private static int readMenuChoice() {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your choice (1-5): ");
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    validInput = true; // choice is within the accepted range
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Thrown when the user types something that is not an integer, e.g. "abc"
                System.out.println("Invalid input! Please enter a whole number (1-5).");
                scanner.next(); // discard the invalid token so it doesn't cause an infinite loop
            }
        }
        return choice;
    }

    /**
     * Safely reads a decimal number from the user.
     * Keeps asking until a valid number is entered.
     *
     * @param prompt the message shown to the user before reading input
     * @return a valid double value entered by the user
     */
    private static double readDouble(String prompt) {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                // Thrown when the input cannot be parsed as a number, e.g. "abc" or "12@3"
                System.out.println("Invalid input! Please enter a valid number (e.g., 10 or 3.5).");
                scanner.next(); // discard the invalid token
            }
        }
        return value;
    }

    // ---------------------------------------------------------
    // Arithmetic operations - each kept in its own small method
    // so the logic is easy to read, test, and reuse.
    // ---------------------------------------------------------

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        // Caller already checks for b == 0 before calling this method,
        // but keeping divide() focused only on the division keeps it simple and reusable.
        return a / b;
    }

    /**
     * Prints the final result in a clean, user-friendly format.
     */
    private static void printResult(int choice, double num1, double num2, double result) {
        String symbol;
        switch (choice) {
            case 1: symbol = "+"; break;
            case 2: symbol = "-"; break;
            case 3: symbol = "*"; break;
            case 4: symbol = "/"; break;
            default: symbol = "?";
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, symbol, num2, result);
        System.out.println("-------------------------------------------------");
    }
}
