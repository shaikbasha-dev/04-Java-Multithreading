07 - Thread Methods in Java

================================================================================
TOPIC OVERVIEW
================================================================================
Java provides many built-in methods in the Thread class to control and manage the
execution of threads. These methods are used to start threads, pause them, make
one thread wait for another, inspect their state, and control scheduling.

Why this topic is important:
- It helps developers control thread execution effectively.
- It is essential for writing correct concurrent programs.
- It is used in real-world applications such as servers, games, and background processing.
- It improves understanding of how threads behave in Java.

================================================================================
1. DEFINITION OF THREAD METHODS
================================================================================
Thread methods are predefined methods of the Thread class that allow us to manage
thread behavior such as starting, pausing, waiting, naming, and checking status.

These methods are very important because they give us control over the execution flow
of multiple threads.

================================================================================
2. IMPORTANT THREAD METHODS
================================================================================
Some of the most commonly used thread methods are:
- start()
- run()
- sleep(long millis)
- join()
- yield()
- isAlive()
- getName()
- setName(String name)
- currentThread()
- setPriority(int priority)
- getPriority()
- interrupt()
- getState()

================================================================================
3. EXPLANATION OF EACH METHOD
================================================================================
1. start()
   - Starts a new thread.
   - Calls the run() method asynchronously.
   - Must be used instead of directly calling run().

2. run()
   - Contains the actual task to be executed by the thread.
   - If called directly, it runs like a normal method.

3. sleep(long millis)
   - Pauses the currently executing thread for the specified number of milliseconds.
   - Throws InterruptedException.

4. join()
   - Makes one thread wait until another thread completes.
   - Useful when one task depends on another.

5. yield()
   - Temporarily pauses the current thread to allow other threads to run.
   - It is only a suggestion to the scheduler.

6. isAlive()
   - Checks whether a thread is still alive.

7. getName()
   - Returns the name of the thread.

8. setName(String name)
   - Changes the name of the thread.

9. currentThread()
   - Returns the reference to the currently running thread.

10. setPriority(int priority)
    - Sets the priority of the thread.

11. getPriority()
    - Returns the priority of the thread.

12. interrupt()
    - Interrupts a thread that is sleeping or waiting.

13. getState()
    - Returns the current state of a thread.

================================================================================
4. PSEUDOCODE FOR THREAD METHODS
================================================================================
BEGIN
    CREATE thread object
    SET thread name
    SET thread priority
    START thread

    IF thread is alive THEN
        WAIT for it to finish
    ENDIF

    PAUSE thread using sleep()
    GIVE chance to another thread using yield()
    CHECK current thread details
END

================================================================================
5. PROGRAM 1: USING start() AND run()
================================================================================
Headline:
Understanding the Difference Between start() and run()

Program:
public class ThreadMethodExample1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Inside run() method");
        });

        t1.start();
        System.out.println("Main thread finished");
    }
}

Why this program is used:
- It shows the correct way to start a thread using start().
- It explains that run() contains thread logic.

How this helps Java:
- It prevents the common mistake of calling run() directly.
- It teaches correct thread execution.

Line-by-line explanation:
1. public class ThreadMethodExample1 {
   - Declares the class.

2. public static void main(String[] args) {
   - Entry point of the program.

3. Thread t1 = new Thread(() -> {
   - Creates a thread using a lambda expression.

4. System.out.println("Inside run() method");
   - Prints a message inside the thread.

5. });
   - Ends the lambda body.

6. t1.start();
   - Starts the thread.

7. System.out.println("Main thread finished");
   - Prints a message from the main thread.

8. }
   - Ends main.

9. }
   - Ends class.

Comments:
public class ThreadMethodExample1 {
    // Program class.
    public static void main(String[] args) {
        // Main method starts the program.
        Thread t1 = new Thread(() -> {
            // Creates a new thread.
            System.out.println("Inside run() method");
            // Code executed inside the thread.
        });

        t1.start();
        // Starts the thread and runs the task asynchronously.
        System.out.println("Main thread finished");
        // Prints a message from the main thread.
    }
}

Output example:
Inside run() method
Main thread finished

Summary:
This program shows how start() runs the thread code separately from the main thread.

================================================================================
6. PROGRAM 2: USING sleep() METHOD
================================================================================
Headline:
Pausing a Thread with sleep()

Program:
public class ThreadMethodExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread is sleeping");
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
- It demonstrates how to pause a thread.
- It teaches exception handling with sleep().

How this helps Java:
- It lets developers delay operations when needed.
- It shows how threads can wait intentionally.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates a thread.

2. try {
   - Starts a block that may throw an exception.

3. System.out.println("Thread is sleeping");
   - Prints message before sleeping.

4. Thread.sleep(2000);
   - Pauses for 2 seconds.

5. System.out.println("Thread woke up");
   - Prints message after wake-up.

6. } catch (InterruptedException e) {
   - Handles interruption error.

7. e.printStackTrace();
   - Shows error details.

8. }
   - Ends catch block.

9. });
   - Ends lambda expression.

10. t1.start();
    - Starts the thread.

Comments:
public class ThreadMethodExample2 {
    // Program class.
    public static void main(String[] args) {
        // Main method starts execution.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            try {
                // Protects sleep call.
                System.out.println("Thread is sleeping");
                // Message before sleeping.
                Thread.sleep(2000);
                // Makes thread sleep for 2 seconds.
                System.out.println("Thread woke up");
                // Message after sleep.
            } catch (InterruptedException e) {
                // Handles interruption.
                e.printStackTrace();
                // Prints exception details.
            }
        });

        t1.start();
        // Starts the thread.
    }
}

Output:
Thread is sleeping
Thread woke up

Summary:
This program shows how sleep() pauses thread execution for a specific duration.

================================================================================
7. PROGRAM 3: USING join() METHOD
================================================================================
Headline:
Making One Thread Wait for Another Thread Using join()

Program:
public class ThreadMethodExample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Child thread: " + i);
            }
        });

        t1.start();
        t1.join();
        System.out.println("Main thread continues");
    }
}

Why this program is used:
- It demonstrates how one thread can wait until another thread is done.
- It is helpful for tasks that need completion order.

How this helps Java:
- It teaches synchronization of execution order.
- It helps in managing dependencies between threads.

Line-by-line explanation:
1. public static void main(String[] args) throws InterruptedException {
   - Main method declares interruption handling.

2. Thread t1 = new Thread(() -> {
   - Creates a new thread.

3. for (int i = 1; i <= 3; i++) {
   - Loop runs three times.

4. System.out.println("Child thread: " + i);
   - Prints the current count.

5. }
   - Ends loop.

6. });
   - Ends lambda expression.

7. t1.start();
   - Starts the thread.

8. t1.join();
   - Waits until t1 finishes.

9. System.out.println("Main thread continues");
   - Executes after join completes.

Comments:
public class ThreadMethodExample3 {
    // Program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method may throw an exception.
        Thread t1 = new Thread(() -> {
            // Creates a child thread.
            for (int i = 1; i <= 3; i++) {
                // Iterates three times.
                System.out.println("Child thread: " + i);
                // Prints each value.
            }
        });

        t1.start();
        // Starts the child thread.
        t1.join();
        // Waits until the child thread finishes.
        System.out.println("Main thread continues");
        // Runs after the child thread completes.
    }
}

Output:
Child thread: 1
Child thread: 2
Child thread: 3
Main thread continues

Summary:
This program shows how join() can make one thread wait for another.

================================================================================
8. PROGRAM 4: USING yield() METHOD
================================================================================
Headline:
Giving Another Thread a Chance to Run with yield()

Program:
public class ThreadMethodExample4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                Thread.yield();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
                Thread.yield();
            }
        });

        t1.start();
        t2.start();
    }
}

Why this program is used:
- It shows how yield() can give other threads a chance to run.
- It helps understand thread scheduling behavior.

How this helps Java:
- It demonstrates how the scheduler may switch between threads.
- It teaches that yield() is not guaranteed to force another thread to run.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates first thread.

2. for (int i = 1; i <= 5; i++) {
   - Loop runs five times.

3. System.out.println("Thread 1: " + i);
   - Prints value for thread 1.

4. Thread.yield();
   - Gives other threads a chance to execute.

5. }
   - Ends loop.

6. });
   - Ends lambda expression.

7. Thread t2 = new Thread(() -> {
   - Creates second thread.

8. for (int i = 1; i <= 5; i++) {
   - Loop runs five times.

9. System.out.println("Thread 2: " + i);
   - Prints value for thread 2.

10. Thread.yield();
    - Gives other threads a chance to execute.

11. }
    - Ends loop.

12. });
    - Ends lambda expression.

13. t1.start();
    - Starts first thread.

14. t2.start();
    - Starts second thread.

Comments:
public class ThreadMethodExample4 {
    // Program class.
    public static void main(String[] args) {
        // Start of program.
        Thread t1 = new Thread(() -> {
            // First thread.
            for (int i = 1; i <= 5; i++) {
                // Loop runs five times.
                System.out.println("Thread 1: " + i);
                // Prints thread 1 value.
                Thread.yield();
                // Gives another thread a chance to run.
            }
        });

        Thread t2 = new Thread(() -> {
            // Second thread.
            for (int i = 1; i <= 5; i++) {
                // Loop runs five times.
                System.out.println("Thread 2: " + i);
                // Prints thread 2 value.
                Thread.yield();
                // Gives another thread a chance to run.
            }
        });

        t1.start();
        // Starts first thread.
        t2.start();
        // Starts second thread.
    }
}

Output example:
Thread 1: 1
Thread 2: 1
Thread 1: 2
Thread 2: 2
Thread 1: 3
Thread 2: 3
Thread 1: 4
Thread 2: 4
Thread 1: 5
Thread 2: 5

Summary:
This program shows how yield() may allow other threads to execute.

================================================================================
9. PROGRAM 5: USING getName(), setName(), and currentThread()
================================================================================
Headline:
Checking and Changing Thread Information

Program:
public class ThreadMethodExample5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Current thread name: " + Thread.currentThread().getName());
        }, "WorkerThread");

        t1.setName("CustomThread");
        System.out.println("Thread name before start: " + t1.getName());
        t1.start();
    }
}

Why this program is used:
- It shows how to inspect and change thread names.
- It explains the use of currentThread().

How this helps Java:
- It helps in debugging and identifying threads.
- It teaches developers to control thread identity.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates a new thread.

2. System.out.println("Current thread name: " + Thread.currentThread().getName());
   - Prints the name of the current thread.

3. }, "WorkerThread");
   - Assigns the initial name WorkerThread.

4. t1.setName("CustomThread");
   - Changes the thread name.

5. System.out.println("Thread name before start: " + t1.getName());
   - Prints the updated thread name.

6. t1.start();
   - Starts the thread.

Comments:
public class ThreadMethodExample5 {
    // Program class.
    public static void main(String[] args) {
        // Program starts here.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            System.out.println("Current thread name: " + Thread.currentThread().getName());
            // Prints the current thread's name.
        }, "WorkerThread");
        // Initializes thread with the name WorkerThread.

        t1.setName("CustomThread");
        // Changes the thread's name.
        System.out.println("Thread name before start: " + t1.getName());
        // Prints the updated thread name.
        t1.start();
        // Starts the thread.
    }
}

Output:
Thread name before start: CustomThread
Current thread name: CustomThread

Summary:
This program shows how to name, inspect, and identify threads.

================================================================================
10. PROGRAM 6: USING isAlive() AND getState()
================================================================================
Headline:
Checking If a Thread Is Still Running

Program:
public class ThreadMethodExample6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        System.out.println("Is thread alive before join? " + t1.isAlive());
        t1.join();
        System.out.println("Is thread alive after join? " + t1.isAlive());
        System.out.println("Thread state after completion: " + t1.getState());
    }
}

Why this program is used:
- It shows how to check if a thread is alive.
- It demonstrates how to inspect thread state.

How this helps Java:
- It helps monitor thread execution.
- It makes debugging easier.

Line-by-line explanation:
1. Thread t1 = new Thread(() -> {
   - Creates a thread.

2. try {
   - Starts exception handling block.

3. Thread.sleep(1000);
   - Makes the thread sleep for 1 second.

4. } catch (InterruptedException e) {
   - Catches exception.

5. e.printStackTrace();
   - Prints exception details.

6. }
   - Ends catch block.

7. });
   - Ends lambda expression.

8. t1.start();
   - Starts the thread.

9. System.out.println("Is thread alive before join? " + t1.isAlive());
   - Prints whether thread is alive before joining.

10. t1.join();
    - Waits for thread to finish.

11. System.out.println("Is thread alive after join? " + t1.isAlive());
    - Prints whether thread is alive after joining.

12. System.out.println("Thread state after completion: " + t1.getState());
    - Prints final state of thread.

Comments:
public class ThreadMethodExample6 {
    // Program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method may throw exception.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            try {
                // Tries to sleep.
                Thread.sleep(1000);
                // Sleeps for 1 second.
            } catch (InterruptedException e) {
                // Handles interruption.
                e.printStackTrace();
                // Prints exception details.
            }
        });

        t1.start();
        // Starts the thread.
        System.out.println("Is thread alive before join? " + t1.isAlive());
        // Checks if thread is alive before join.
        t1.join();
        // Waits until thread completes.
        System.out.println("Is thread alive after join? " + t1.isAlive());
        // Checks if thread is alive after join.
        System.out.println("Thread state after completion: " + t1.getState());
        // Prints final thread state.
    }
}

Output example:
Is thread alive before join? true
Is thread alive after join? false
Thread state after completion: TERMINATED

Summary:
This program shows how to use isAlive() and getState() to monitor thread status.

================================================================================
11. COMMON MISTAKES RELATED TO THREAD METHODS
================================================================================
- Calling run() instead of start()
- Forgetting to handle InterruptedException
- Using sleep() without understanding that it pauses only the current thread
- Assuming yield() guarantees another thread will run
- Not joining threads when task order matters

================================================================================
12. FINAL SUMMARY
================================================================================
Thread methods are essential tools for controlling the behavior of threads in Java.
Methods like start(), run(), sleep(), join(), yield(), isAlive(), getName(),
setName(), currentThread(), and getState() allow developers to start tasks,
pause execution, coordinate threads, and inspect their states. Learning these methods
helps build reliable and efficient multithreaded programs.

================================================================================
13. PROFESSIONAL NOTE FOR REPOSITORY USE
================================================================================
This topic is excellent for a GitHub repository because it covers:
- definitions
- method explanations
- practical code examples
- complete comments
- outputs and summaries

A good repository layout for this topic can be:
- theory/
- examples/
- outputs/
- notes/
