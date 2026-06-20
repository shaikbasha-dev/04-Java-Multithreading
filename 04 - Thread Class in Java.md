04 - Thread Class in Java

================================================================================
TOPIC OVERVIEW
================================================================================
In Java, the Thread class is one of the most important classes used for creating
and managing threads. A thread is a separate path of execution inside a program.
The Thread class allows a developer to create new threads, control their behavior,
and manage their lifecycle.

Why this topic is important:
- It is the core building block of Java multithreading.
- It helps developers write programs that can perform multiple tasks together.
- It is essential for understanding how Java handles concurrency.
- It prepares learners for more advanced concepts like synchronization, executor framework,
  and parallel processing.

================================================================================
1. DEFINITION OF THREAD CLASS
================================================================================
The Thread class is a predefined class in Java that represents a thread of execution.
It provides methods to start, pause, stop, and manage threads.

The Thread class is defined in the java.lang package, so we do not need to import it.

================================================================================
2. WHAT IS A THREAD?
================================================================================
A thread is the smallest unit of execution in a program.

It can be thought of as:
- a lightweight process
- a path of execution inside a program
- a worker that runs code independently

Every Java program starts with at least one thread, which is the main thread.

================================================================================
3. WHY THE Thread CLASS IS IMPORTANT
================================================================================
The Thread class is important because it allows us to:
- create new threads
- run multiple tasks simultaneously
- make programs more responsive
- handle background operations efficiently
- improve performance in applications that need parallel execution

================================================================================
4. THREAD CLASS VS Runnable INTERFACE
================================================================================
Both are used to create threads, but they are different:

Thread class:
- Use when you want to override run() directly.
- Gives direct access to thread methods.
- You cannot inherit from another class if you extend Thread.

Runnable interface:
- Better when you want to separate task logic from thread logic.
- More flexible because a class can implement Runnable and also extend another class.

================================================================================
5. IMPORTANT METHODS OF THE Thread CLASS
================================================================================
Here are some common methods:

- start() -> starts a new thread and calls run()
- run() -> contains the code executed by the thread
- sleep(long millis) -> pauses a thread for a specified time
- join() -> waits for another thread to finish
- getName() -> returns thread name
- setName(String name) -> changes thread name
- currentThread() -> returns the currently executing thread
- isAlive() -> checks if thread is alive
- setPriority(int p) -> sets priority of thread
- yield() -> gives chance to another thread to execute

================================================================================
6. THREAD LIFE CYCLE
================================================================================
A thread goes through several states:

- New: thread object is created but not started yet
- Runnable: thread is ready to run
- Running: thread is actively executing
- Blocked/Waiting: thread waits for resource or another thread
- Terminated: thread has finished execution

================================================================================
7. PSEUDOCODE FOR USING THE Thread CLASS
================================================================================
BEGIN
    CREATE thread object
    SET thread name if needed
    CALL start() to begin execution
    THREAD runs the code inside run()
    WAIT if needed
    DISPLAY result
END

================================================================================
8. PROGRAM 1: CREATING A THREAD BY EXTENDING Thread CLASS
================================================================================
Headline:
Creating a Simple Thread by Extending the Thread Class

Program:
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
        }
    }
}

public class ThreadClassExample1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main thread is executing");
    }
}

Why this program is used:
- It shows the simplest way to create a thread.
- It explains how the Thread class is extended to define custom thread behavior.
- It helps beginners relate the concept of a thread with real code.

How this helps Java:
- It demonstrates the core idea of concurrent execution.
- It gives a clear example of how the run() method works.
- It builds the foundation for understanding advanced thread handling.

Line-by-line explanation:
1. class MyThread extends Thread {
   - Creates a new class that inherits from Thread.

2. public void run() {
   - Defines the task that the thread will execute.

3. for (int i = 1; i <= 5; i++) {
   - Starts a loop that runs five times.

4. System.out.println("Thread running: " + i);
   - Prints the current iteration value.

5. }
   - Ends the loop.

6. }
   - Ends the run() method.

7. }
   - Ends the custom thread class.

8. public class ThreadClassExample1 {
   - Declares the main class.

9. public static void main(String[] args) {
   - Main method where execution starts.

10. MyThread t1 = new MyThread();
    - Creates a new thread object.

11. t1.start();
    - Starts the thread so run() executes.

12. System.out.println("Main thread is executing");
    - Prints a message from the main thread.

13. }
    - Ends the main method.

14. }
    - Ends the main class.

Comments:
class MyThread extends Thread {
    // Creates a custom class that represents a thread.
    public void run() {
        // Code inside this method runs when the thread starts.
        for (int i = 1; i <= 5; i++) {
            // Repeats five times.
            System.out.println("Thread running: " + i);
            // Prints the current value of i.
        }
    }
}

public class ThreadClassExample1 {
    // Main program class.
    public static void main(String[] args) {
        // Execution starts here.
        MyThread t1 = new MyThread();
        // Creates a new thread object.
        t1.start();
        // Starts the thread.
        System.out.println("Main thread is executing");
        // Prints a message from the main thread.
    }
}

Output example:
Main thread is executing
Thread running: 1
Thread running: 2
Thread running: 3
Thread running: 4
Thread running: 5

Summary:
This program demonstrates how to create a thread by extending the Thread class.

================================================================================
9. PROGRAM 2: USING start() AND run() DIFFERENTLY
================================================================================
Headline:
Understanding the Difference Between start() and run()

Program:
public class ThreadClassExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Inside run() method");
        });

        t1.run();
        System.out.println("After run() call");
    }
}

Why this program is used:
- It helps understand the difference between calling run() directly and calling start().
- It shows that run() is just a normal method call unless start() is used.

How this helps Java:
- It prevents beginners from making a common mistake.
- It teaches the correct way to execute code in a separate thread.

Line-by-line explanation:
1. public class ThreadClassExample2 {
   - Declares the class.

2. public static void main(String[] args) {
   - Main method.

3. Thread t1 = new Thread(() -> {
   - Creates a thread using a lambda expression.

4. System.out.println("Inside run() method");
   - Prints a message.

5. });
   - Ends the lambda body.

6. t1.run();
   - Calls run() directly.

7. System.out.println("After run() call");
   - Prints another message.

8. }
   - Ends main.

9. }
   - Ends class.

Comments:
public class ThreadClassExample2 {
    // Program class.
    public static void main(String[] args) {
        // Starts execution.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            System.out.println("Inside run() method");
            // This message is printed when run() is executed.
        });

        t1.run();
        // Calls run() directly, not as a new thread.
        System.out.println("After run() call");
        // Prints after the run() call finishes.
    }
}

Output:
Inside run() method
After run() call

Summary:
This program explains why `start()` should be used instead of directly calling `run()`.

================================================================================
10. PROGRAM 3: SETTING THREAD NAME AND PRIORITY
================================================================================
Headline:
Naming and Prioritizing Threads

Program:
public class ThreadClassExample3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "WorkerThread");

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }
}

Why this program is used:
- It shows how to name a thread.
- It also demonstrates setting thread priority.
- It helps learners understand thread identity and scheduling.

How this helps Java:
- It makes debugging easier because threads can be identified by name.
- It teaches how priority may influence scheduling behavior.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates a thread.

2. System.out.println(Thread.currentThread().getName());
   - Prints the current thread's name.

3. }, "WorkerThread");
   - Gives the thread the name WorkerThread.

4. t1.setPriority(Thread.MAX_PRIORITY);
   - Sets the thread to highest priority.

5. t1.start();
   - Starts the thread.

Comments:
public class ThreadClassExample3 {
    // Program class.
    public static void main(String[] args) {
        // Execution starts here.
        Thread t1 = new Thread(() -> {
            // Creates a new thread.
            System.out.println(Thread.currentThread().getName());
            // Prints the name of the current thread.
        }, "WorkerThread");
        // Names this thread WorkerThread.

        t1.setPriority(Thread.MAX_PRIORITY);
        // Sets the thread priority to the maximum possible value.
        t1.start();
        // Starts the thread.
    }
}

Output:
WorkerThread

Summary:
This program shows how to assign names and set priorities to threads.

================================================================================
11. PROGRAM 4: USING sleep() METHOD IN A THREAD
================================================================================
Headline:
Delaying Thread Execution with sleep()

Program:
public class ThreadClassExample4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread is going to sleep");
                Thread.sleep(2000);
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
    }
}

Why this program is used:
- It shows how a thread can pause execution temporarily.
- It explains how exception handling works when using sleep().

How this helps Java:
- It teaches timing control for threads.
- It helps in applications that need waiting or delays.

Line-by-line explanation:
1. try {
   - Begins exception handling block.

2. System.out.println("Thread is going to sleep");
   - Prints a message before sleeping.

3. Thread.sleep(2000);
   - Pauses the thread for 2 seconds.

4. System.out.println("Thread woke up");
   - Prints message after sleep ends.

5. } catch (InterruptedException e) {
   - Catches an interruption error.

6. e.printStackTrace();
   - Prints the error details.

Comments:
public class ThreadClassExample4 {
    // Program class.
    public static void main(String[] args) {
        // Main method starts execution.
        Thread t1 = new Thread(() -> {
            // Creates thread.
            try {
                // Starts protected block.
                System.out.println("Thread is going to sleep");
                // Message before sleep.
                Thread.sleep(2000);
                // Pauses for 2 seconds.
                System.out.println("Thread woke up");
                // Message after waking.
            } catch (InterruptedException e) {
                // Handles sleep interruption.
                e.printStackTrace();
                // Prints the exception details.
            }
        });

        t1.start();
        // Starts the thread.
    }
}

Output:
Thread is going to sleep
Thread woke up

Summary:
This program explains how the Thread class can pause execution using sleep().

================================================================================
12. PROGRAM 5: USING join() METHOD
================================================================================
Headline:
Waiting for a Thread to Finish Using join()

Program:
public class ThreadClassExample5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Task: " + i);
            }
        });

        t1.start();
        t1.join();
        System.out.println("Main thread continues after join");
    }
}

Why this program is used:
- It shows how one thread can wait for another thread to finish.
- It helps understand thread coordination.

How this helps Java:
- It teaches how to control execution order when needed.
- It is useful in applications where one task depends on another.

Line-by-line explanation:
1. public static void main(String[] args) throws InterruptedException {
   - Main method declares that it may throw interruption exception.

2. t1.start();
   - Starts the thread.

3. t1.join();
   - Waits until the thread finishes.

4. System.out.println("Main thread continues after join");
   - Executes after the child thread is complete.

Comments:
public class ThreadClassExample5 {
    // Program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method may throw an exception.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            for (int i = 1; i <= 3; i++) {
                // Loop runs three times.
                System.out.println("Task: " + i);
                // Prints each task number.
            }
        });

        t1.start();
        // Starts thread t1.
        t1.join();
        // Waits for t1 to finish before continuing.
        System.out.println("Main thread continues after join");
        // Runs after t1 completes.
    }
}

Output:
Task: 1
Task: 2
Task: 3
Main thread continues after join

Summary:
This program demonstrates how join() is used to wait for a thread to complete.

================================================================================
13. COMMON MISTAKES WHEN USING Thread CLASS
================================================================================
- Calling run() directly instead of start()
- Not handling InterruptedException properly
- Forgetting that output order is not guaranteed
- Using too many threads without control
- Sharing data without synchronization

================================================================================
14. FINAL SUMMARY
================================================================================
The Thread class is one of the most important parts of Java multithreading.
It allows developers to create and manage threads, control execution flow, and
build applications that perform multiple tasks at once. Understanding methods like
start(), run(), sleep(), join(), and setPriority() is essential for writing correct
and efficient concurrent programs.

================================================================================
15. PROFESSIONAL NOTE FOR REPOSITORY USE
================================================================================
This topic is excellent for GitHub documentation because it covers:
- definition and theory
- practical code examples
- line-by-line explanation
- comments for every line
- outputs and summaries

A clean folder structure for this topic can be:
- theory/
- examples/
- outputs/
- notes/
