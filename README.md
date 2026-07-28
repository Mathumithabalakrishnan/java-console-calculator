# Java Console Calculator

A simple, beginner-friendly **console-based calculator** built using **Core Java**.
Created as part of a Java Programming Internship (Task 1).

## Features

- Menu-driven console interface
- Supports Addition, Subtraction, Multiplication, and Division
- Input validation — the program never crashes on invalid input (letters, symbols, etc.)
- Graceful handling of division by zero
- Runs continuously in a loop until the user selects **Exit**
- Clean, modular code with a separate method for each operation
- Well-commented code, ideal for learning and demonstration

## Tech Stack

- **Language:** Java (Core Java, no external libraries)
- **Input handling:** `java.util.Scanner`
- **Compatible with:** VS Code, IntelliJ IDEA, Eclipse, or plain terminal (JDK 8+)

## Project Structure

```
calculator/
├── Calculator.java   # Main source file — contains all logic
└── README.md         # Project documentation
```

## How to Run

### Option 1: Command Line (any OS with JDK installed)

```bash
# 1. Compile the program
javac Calculator.java

# 2. Run the compiled program
java Calculator
```

### Option 2: IntelliJ IDEA / Eclipse / VS Code

1. Create a new Java project.
2. Add `Calculator.java` to the `src` folder.
3. Run the file directly (Run ▶ button, or right-click → Run).

## Sample Interaction

```
=================================================
        WELCOME TO THE JAVA CONSOLE CALCULATOR   
=================================================
-------------------------------------------------
Please choose an operation:
1. Addition       (+)
2. Subtraction    (-)
3. Multiplication (*)
4. Division       (/)
5. Exit
-------------------------------------------------
Enter your choice (1-5): 1
Enter the first number  : 10
Enter the second number : 5
-------------------------------------------------
Result: 10.00 + 5.00 = 15.00
-------------------------------------------------
```

## Edge Cases Handled

- Non-numeric menu choice (e.g., typing `abc`)
- Out-of-range menu choice (e.g., `9`)
- Non-numeric number input (e.g., typing `ten`)
- Division by zero
- Continues running until the user explicitly exits

## Possible Future Enhancements

- Add support for advanced operations (modulus, power, square root)
- Support chained/multi-step calculations
- Add a GUI version using JavaFX or Swing
- Maintain a calculation history log
- Add unit tests using JUnit

## Author

`Mathumitha` — Java Programming Intern
