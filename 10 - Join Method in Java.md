10 - Join Method in Java

================================================================================
TOPIC OVERVIEW
================================================================================
The join() method is used when one thread wants to wait for another thread to
finish its execution. It is one of the most important methods in Java multithreading
because it helps control the order of execution between threads.

Why this topic is important:
- It helps coordinate multiple threads.
- It is useful when one task depends on another task.
- It improves understanding of thread synchronization at a basic level.
- It is commonly used in interview questions and practical coding examples.

================================================================================
1. DEFINITION OF join() METHOD
================================================================================
The join() method belongs to the Thread class.

It allows a thread to wait until another thread completes its execution.

Syntax:
thread.join();

It is usually called on a thread object.

================================================================================
2. WHAT DOES join() DO?
================================================================================
The join() method:
- makes the current thread wait for the specified thread to finish
- ensures the calling thread continues only after the target thread completes
- helps maintain order in multithreaded programs

================================================================================
3. WHY DO WE USE join()?
================================================================================
We use join() when:
- one thread needs results produced by another thread
- we want a main thread to wait for worker threads before continuing
- we want to ensure all tasks complete before moving ahead

This is especially useful in applications where certain operations depend on each other.

================================================================================
4. IMPORTANT POINTS ABOUT join()
================================================================================
- join() throws InterruptedException.
- It can be called on a thread object.
- If multiple threads are waiting, the order is controlled by the scheduler.
- join() does not make the thread run faster; it only waits.

================================================================================
5. PSEUDOCODE FOR join()
================================================================================
BEGIN
    CREATE thread T1
    CREATE thread T2

    START T1
    START T2

    CALL T1.join()
    CALL T2.join()

    DISPLAY message after both threads finish
END

================================================================================
6. PROGRAM 1: BASIC join() EXAMPLE
================================================================================
Headline:
Waiting for a Thread to Finish Using join()

Program:
public class JoinExample1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Child thread: " + i);
            }
        });

        t1.start();
        t1.join();
        System.out.println("Main thread continues after join");
    }
}

Why this program is used:
- It shows the simplest use of join().
- It explains how the main thread waits for a child thread to complete.

How this helps Java:
- It teaches the basic purpose of join().
- It shows how output order can be controlled when needed.

Line-by-line explanation:
1. public class JoinExample1 {
   - Declares the class.

2. public static void main(String[] args) throws InterruptedException {
   - Main method may throw InterruptedException.

3. Thread t1 = new Thread(() -> {
   - Creates a child thread.

4. for (int i = 1; i <= 3; i++) {
   - Loop runs three times.

5. System.out.println("Child thread: " + i);
   - Prints each iteration value.

6. }
   - Ends the loop.

7. });
   - Ends lambda expression.

8. t1.start();
   - Starts the thread.

9. t1.join();
   - Waits until t1 finishes.

10. System.out.println("Main thread continues after join");
    - Prints message after child thread completes.

11. }
    - Ends main.

12. }
    - Ends class.

Comments:
public class JoinExample1 {
    // Main program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method can throw interruption exception.
        Thread t1 = new Thread(() -> {
            // Creates a child thread.
            for (int i = 1; i <= 3; i++) {
                // Repeats three times.
                System.out.println("Child thread: " + i);
                // Prints the current iteration.
            }
        });

        t1.start();
        // Starts the child thread.
        t1.join();
        // Waits until t1 finishes.
        System.out.println("Main thread continues after join");
        // Runs only after the child thread completes.
    }
}

Output:
Child thread: 1
Child thread: 2
Child thread: 3
Main thread continues after join

Summary:
This example shows how join() makes the main thread wait for the child thread to finish.

================================================================================
7. PROGRAM 2: JOINING TWO THREADS
================================================================================
Headline:
Waiting for Multiple Threads with join()

Program:
public class JoinExample2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Both threads completed");
    }
}

Why this program is used:
- It shows how to wait for more than one thread.
- It explains how the main thread can continue only after all important tasks are done.

How this helps Java:
- It teaches coordination between multiple background tasks.
- It is helpful in programs where all worker threads must finish before results are shown.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates first thread.

2. for (int i = 1; i <= 3; i++) {
   - Loop runs three times.

3. System.out.println("Thread 1: " + i);
   - Prints the current value of thread 1.

4. }
   - Ends loop.

5. });
   - Ends lambda expression.

6. Thread t2 = new Thread(() -> {
   - Creates second thread.

7. for (int i = 1; i <= 3; i++) {
   - Loop runs three times.

8. System.out.println("Thread 2: " + i);
   - Prints the current value of thread 2.

9. }
   - Ends loop.

10. });
    - Ends lambda expression.

11. t1.start();
    - Starts thread 1.

12. t2.start();
    - Starts thread 2.

13. t1.join();
    - Waits for thread 1 to finish.

14. t2.join();
    - Waits for thread 2 to finish.

15. System.out.println("Both threads completed");
    - Prints message after both threads finish.

Comments:
public class JoinExample2 {
    // Program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method may throw interruption exception.
        Thread t1 = new Thread(() -> {
            // Creates first thread.
            for (int i = 1; i <= 3; i++) {
                // Loop runs three times.
                System.out.println("Thread 1: " + i);
                // Prints the current value.
            }
        });

        Thread t2 = new Thread(() -> {
            // Creates second thread.
            for (int i = 1; i <= 3; i++) {
                // Loop runs three times.
                System.out.println("Thread 2: " + i);
                // Prints the current value.
            }
        });

        t1.start();
        // Starts thread 1.
        t2.start();
        // Starts thread 2.

        t1.join();
        // Waits until thread 1 finishes.
        t2.join();
        // Waits until thread 2 finishes.

        System.out.println("Both threads completed");
        // Runs after both threads are done.
    }
}

Output example:
Thread 1: 1
Thread 2: 1
Thread 1: 2
Thread 2: 2
Thread 1: 3
Thread 2: 3
Both threads completed

Summary:
This program shows how join() can be used to wait for multiple threads to finish.

================================================================================
8. PROGRAM 3: join() WITH sleep()
================================================================================
Headline:
Combining join() and sleep() for Controlled Execution

Program:
public class JoinExample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 1 finished after sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t1.join();
        System.out.println("Main thread continues after thread 1 completes");
    }
}

Why this program is used:
- It shows how join() can be combined with sleep().
- It explains how a thread can wait some time and then finish.

How this helps Java:
- It demonstrates practical use of both methods together.
- It helps understand timing and coordination in thread programming.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates a new thread.

2. try {
   - Starts exception handling block.

3. Thread.sleep(1000);
   - Makes the thread wait for 1 second.

4. System.out.println("Thread 1 finished after sleep");
   - Prints message after the wait.

5. } catch (InterruptedException e) {
   - Handles interruption exception.

6. e.printStackTrace();
   - Prints exception details.

7. }
   - Ends exception block.

8. });
   - Ends lambda expression.

9. t1.start();
   - Starts the thread.

10. t1.join();
    - Waits until the thread completes.

11. System.out.println("Main thread continues after thread 1 completes");
    - Prints message after join.

Comments:
public class JoinExample3 {
    // Program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method may throw exception.
        Thread t1 = new Thread(() -> {
            // Creates a child thread.
            try {
                // Tries to pause thread.
                Thread.sleep(1000);
                // Sleeps for 1 second.
                System.out.println("Thread 1 finished after sleep");
                // Prints message after sleep ends.
            } catch (InterruptedException e) {
                // Handles interruption.
                e.printStackTrace();
                // Prints exception details.
            }
        });

        t1.start();
        // Starts thread 1.
        t1.join();
        // Waits until thread 1 completes.
        System.out.println("Main thread continues after thread 1 completes");
        // Runs after thread 1 is done.
    }
}

Output:
Thread 1 finished after sleep
Main thread continues after thread 1 completes

Summary:
This program shows how join() can be used after a thread performs a delay.

================================================================================
9. COMMON DIFFERENCES BETWEEN sleep() AND join()
================================================================================
sleep():
- pauses the current thread itself
- does not wait for another thread to finish

join():
- waits for another thread to finish
- used for coordination between threads

================================================================================
10. COMMON MISTAKES WITH join()
================================================================================
- Forgetting to handle InterruptedException
- Calling join() on a thread that has not started yet
- Assuming join() guarantees a specific output order in all cases

================================================================================
11. FINAL SUMMARY
================================================================================
The join() method is used to make one thread wait until another thread finishes.
It is especially useful when one task depends on another. Although it does not make
threads run faster, it helps in ordering and coordination, making the program easier
to control and understand.

================================================================================
12. PROFESSIONAL NOTE FOR REPOSITORY USE
================================================================================
This topic is excellent for a GitHub repository because it includes:
- clear theory
- practical programs
- line-by-line explanation
- comments for each statement
- outputs and summary sections

A good folder structure can be:
- theory/
- examples/
- outputs/
- notes/
