02 - Single-Threaded Program in Java

================================================================================
TOPIC OVERVIEW
================================================================================
A single-threaded program is a program in which only one thread of execution runs
at a time. In Java, the main() method runs in the main thread. This means that the
program executes instructions one after another in a sequential manner.

Why this topic is important:
- It helps us understand how Java programs work before learning multithreading.
- It explains the default flow of execution.
- It gives a strong foundation for understanding concurrency and parallelism.
- It shows why multithreading is needed when we want multiple tasks to run together.

================================================================================
1. DEFINITION OF SINGLE-THREADED PROGRAM
================================================================================
A single-threaded program is a Java program that has exactly one active path of
execution. The program starts from main(), follows one instruction flow, and
finishes that flow before moving to another independent task.

In simple terms:
- One thread executes all the instructions.
- There is no simultaneous execution of multiple tasks inside the program.
- If one task is slow, the rest of the program must wait.

================================================================================
2. DEFINITION OF THREAD
================================================================================
A thread is the smallest unit of execution in a program.

Important points:
- A thread is responsible for running a sequence of instructions.
- A Java program always starts with one thread called the main thread.
- If we create more threads, the program becomes multi-threaded.

================================================================================
3. WHAT IS THE MAIN THREAD?
================================================================================
The main thread is the first thread created when a Java program starts.
It executes the main() method.

Example:
public static void main(String[] args)

This line tells Java:
- Start execution from here.
- Accept command-line inputs if any.
- Run all statements in this method in the main thread.

================================================================================
4. WHY USE A SINGLE-THREADED PROGRAM?
================================================================================
A single-threaded program is useful when:
- The tasks are very simple.
- The program does not need parallel execution.
- We want easy debugging and predictable flow.
- The logic is sequential and easy to understand.

It helps Java developers because:
- It teaches the basics of control flow.
- It shows how methods are called.
- It helps in understanding how Java programs move from one statement to another.
- It becomes easier to compare single-threaded and multi-threaded behavior later.

================================================================================
5. ADVANTAGES OF SINGLE-THREADED PROGRAMS
================================================================================
- Easy to understand.
- Easy to debug.
- No synchronization issues.
- No race conditions.
- No deadlock problem.
- Good for small programs and beginners.

================================================================================
6. DISADVANTAGES OF SINGLE-THREADED PROGRAMS
================================================================================
- Slower when performing many tasks at once.
- One long task can block the whole program.
- Not ideal for server applications or large systems.
- Poor use of multi-core processors.

================================================================================
7. PSEUDOCODE FOR SINGLE-THREADED PROGRAM
================================================================================
BEGIN
    DISPLAY message "Program started"
    CALL method to perform task 1
    CALL method to perform task 2
    DISPLAY message "Program finished"
END

This pseudocode shows that each action happens one after another.

================================================================================
8. PROGRAM 1: SIMPLE SINGLE-THREADED PROGRAM
================================================================================
Headline:
Understanding the Flow of a Basic Single-Threaded Java Program

Program:
public class SingleThreadExample1 {
    public static void main(String[] args) {
        System.out.println("Program started");
        System.out.println("This is a single-threaded program");
        System.out.println("Program finished");
    }
}

Why this program is used:
- It shows the simplest form of a Java program.
- It proves that Java executes instructions in sequence.
- It helps beginners understand the main() method.

How this helps Java:
- It teaches the structure of a Java class.
- It explains how output is displayed.
- It builds the base for every Java program.

Line-by-line explanation:
1. public class SingleThreadExample1 {
   - Declares a public class named SingleThreadExample1.
   - Every Java program must have at least one class.

2. public static void main(String[] args) {
   - The main method is the entry point of the program.
   - public means accessible from anywhere.
   - static means the method belongs to the class and can be called without creating an object.
   - void means the method does not return any value.
   - String[] args stores command-line arguments.

3. System.out.println("Program started");
   - Prints the message to the console.
   - println moves the cursor to the next line after printing.

4. System.out.println("This is a single-threaded program");
   - Prints another message.
   - Shows the program is executing in a sequential flow.

5. System.out.println("Program finished");
   - Prints the last message.

6. }
   - Ends the main method.

7. }
   - Ends the class.

Line-by-line comments:
public class SingleThreadExample1 {
    // Declares the class that contains the program logic.
    public static void main(String[] args) {
        // The main method starts the execution of the program.
        System.out.println("Program started");
        // Prints a message to show the program has started.
        System.out.println("This is a single-threaded program");
        // Prints another message to explain the program type.
        System.out.println("Program finished");
        // Prints a message showing the program is ending.
    }
}

Output:
Program started
This is a single-threaded program
Program finished

Summary:
This program introduces the concept of sequential execution in Java.

================================================================================
9. PROGRAM 2: SINGLE-THREADED PROGRAM USING METHODS
================================================================================
Headline:
Understanding Method Calls in a Single-Threaded Java Program

Program:
public class SingleThreadExample2 {
    public static void main(String[] args) {
        System.out.println("Starting program");
        greetUser();
        calculateSum();
        System.out.println("Program completed");
    }

    public static void greetUser() {
        System.out.println("Hello, welcome to Java");
    }

    public static void calculateSum() {
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println("Sum is: " + sum);
    }
}

Why this program is used:
- It shows how methods are called one by one.
- It explains that Java follows a single flow of execution.
- It demonstrates modular programming.

How this helps Java:
- It improves code readability.
- It allows reuse of logic.
- It teaches that each method executes only when it is called.

Line-by-line explanation:
1. public class SingleThreadExample2 {
   - Creates the class.

2. public static void main(String[] args) {
   - Entry point of the program.

3. System.out.println("Starting program");
   - Displays a starting message.

4. greetUser();
   - Calls the greetUser() method.

5. calculateSum();
   - Calls the calculateSum() method.

6. System.out.println("Program completed");
   - Prints the final message.

7. }
   - Ends main.

8. public static void greetUser() {
   - Defines a method that prints a greeting.

9. System.out.println("Hello, welcome to Java");
   - Prints the greeting.

10. }
   - Ends greetUser.

11. public static void calculateSum() {
   - Defines a method that calculates sum.

12. int a = 10;
   - Declares integer variable a with value 10.

13. int b = 20;
   - Declares integer variable b with value 20.

14. int sum = a + b;
   - Adds a and b and stores result in sum.

15. System.out.println("Sum is: " + sum);
   - Prints the result.

16. }
   - Ends calculateSum.

17. }
   - Ends class.

Comments:
public class SingleThreadExample2 {
    // Class declaration for the program.
    public static void main(String[] args) {
        // Main method begins execution.
        System.out.println("Starting program");
        // Prints a message before running other tasks.
        greetUser();
        // Calls the method that prints a welcome message.
        calculateSum();
        // Calls the method that calculates and prints the sum.
        System.out.println("Program completed");
        // Prints a message after all tasks are finished.
    }

    public static void greetUser() {
        // Method to print a welcome message.
        System.out.println("Hello, welcome to Java");
        // Prints the greeting message.
    }

    public static void calculateSum() {
        // Method to calculate the sum of two numbers.
        int a = 10;
        // Stores first number.
        int b = 20;
        // Stores second number.
        int sum = a + b;
        // Computes the result of a + b.
        System.out.println("Sum is: " + sum);
        // Prints the final sum.
    }
}

Output:
Starting program
Hello, welcome to Java
Sum is: 30
Program completed

Summary:
This program shows how a single-threaded Java application executes methods one after another.

================================================================================
10. PROGRAM 3: SINGLE-THREADED PROGRAM WITH USER INPUT
================================================================================
Headline:
Using Input in a Single-Threaded Java Program

Program:
import java.util.Scanner;

public class SingleThreadExample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name);
        sc.close();
    }
}

Why this program is used:
- It shows how a single-threaded program can accept keyboard input.
- It explains how Java reads data from the user.
- It gives a practical example of sequential execution.

How this helps Java:
- It shows how real applications collect user information.
- It helps understand object usage and method calls.
- It prepares the student for input-based programming concepts.

Line-by-line explanation:
1. import java.util.Scanner;
   - Imports the Scanner class used to read input.

2. public class SingleThreadExample3 {
   - Declares the class.

3. public static void main(String[] args) {
   - Main method used to start execution.

4. Scanner sc = new Scanner(System.in);
   - Creates a Scanner object to read from keyboard.

5. System.out.print("Enter your name: ");
   - Asks the user to enter a name.

6. String name = sc.nextLine();
   - Reads the whole line entered by the user.

7. System.out.println("Hello, " + name);
   - Prints a greeting using the entered name.

8. sc.close();
   - Closes the scanner to free resources.

Comments:
import java.util.Scanner;
// Imports the Scanner class needed for reading user input.

public class SingleThreadExample3 {
    // Declares the program class.
    public static void main(String[] args) {
        // The program starts here.
        Scanner sc = new Scanner(System.in);
        // Creates a Scanner object to read data from the user.
        System.out.print("Enter your name: ");
        // Prompts the user to type a name.
        String name = sc.nextLine();
        // Reads the input and stores it in the variable name.
        System.out.println("Hello, " + name);
        // Prints a greeting using the entered name.
        sc.close();
        // Closes the scanner after use.
    }
}

Output example:
Enter your name: John
Hello, John

Summary:
This program shows how a single-threaded Java program can interact with the user.

================================================================================
11. PROGRAM 4: SINGLE-THREADED PROGRAM USING LOOPS
================================================================================
Headline:
Understanding Sequential Execution with Loops

Program:
public class SingleThreadExample4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Value: " + i);
        }
    }
}

Why this program is used:
- It shows that a single thread can repeat tasks in order.
- It teaches the concept of iteration.
- It helps understand control flow clearly.

How this helps Java:
- It improves problem-solving skills.
- It is useful for printing lists, processing arrays, and repeating logic.

Line-by-line explanation:
1. for (int i = 1; i <= 5; i++) {
   - Starts a loop from 1 to 5.

2. System.out.println("Value: " + i);
   - Prints the current value each time.

3. }
   - Ends the loop.

Comments:
public class SingleThreadExample4 {
    // Defines the class.
    public static void main(String[] args) {
        // Main method starts execution.
        for (int i = 1; i <= 5; i++) {
            // Repeats the block while i is between 1 and 5.
            System.out.println("Value: " + i);
            // Prints the current loop value.
        }
    }
}

Output:
Value: 1
Value: 2
Value: 3
Value: 4
Value: 5

Summary:
This program demonstrates sequential repetition in a single-threaded Java program.

================================================================================
12. COMPARISON: SINGLE-THREADED VS MULTI-THREADED
================================================================================
Single-threaded:
- One path of execution.
- Easier to write and debug.
- No concurrency problems.
- Less efficient for complex tasks.

Multi-threaded:
- Multiple paths of execution.
- Better for responsiveness and performance.
- More complex and harder to debug.
- Needs synchronization.

================================================================================
13. IMPORTANT DEFINITIONS RECAP
================================================================================
- Thread: A path of execution in a program.
- Single-threaded program: A program with only one thread running.
- Main thread: The thread that starts the program.
- Sequential execution: Instructions run one after another.
- Method: A block of code used to perform a task.
- Loop: A construct that repeats instructions.

================================================================================
14. FINAL SUMMARY
================================================================================
A single-threaded program in Java runs one task at a time using the main thread.
It is simple, easy to understand, and useful for learning the basic flow of Java.
The main method is the starting point, and methods, loops, and input handling can all
be used inside the program. Although it is not ideal for high-performance multitasking,
it builds the foundation needed to understand multithreading later.

================================================================================
15. PROFESSIONAL NOTE FOR REPOSITORY USE
================================================================================
This topic is suitable for a GitHub repository because it covers:
- beginner-friendly explanation
- real Java programs
- line-by-line notes
- outputs and summaries
- practical understanding of thread basics

You can organize this topic into folders such as:
- basics/
- examples/
- outputs/
- explanations/

This structure will help others understand the progression from single-threaded to
multi-threaded programming.
