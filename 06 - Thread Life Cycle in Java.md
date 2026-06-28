# 06 - Thread Life Cycle in Java

## TOPIC OVERVIEW
The thread life cycle describes the different states a thread goes through from
creation to completion. Understanding the life cycle is very important in Java
because it helps developers know how threads are scheduled, how they wait, and how
they terminate.

**Why this topic is important:**
- It explains how Java manages threads.
- It helps in debugging concurrency issues.
- It improves understanding of thread scheduling.
- It forms the base for concepts like wait(), notify(), sleep(), join(), and synchronization.

## 1. DEFINITION OF THREAD LIFE CYCLE
The thread life cycle is the sequence of states that a thread passes through during
its execution.

A thread can exist in different states such as:
- New
- Runnable
- Running
- Blocked/Waiting
- Terminated

## 2. IMPORTANT STATES OF A THREAD
1. New
   - The thread object is created but not started yet.
   - The run() method has not executed.

2. Runnable
   - The thread is ready to run.
   - It is waiting for CPU time.

3. Running
   - The thread is actively executing its code.

4. Blocked / Waiting
   - The thread is paused because it is waiting for a resource, lock, or another thread.

5. Terminated
   - The thread has finished execution.
   - The run() method has completed.

## 3. SIMPLE FLOW OF LIFE CYCLE
New -> Runnable -> Running -> Blocked/Waiting -> Runnable -> Terminated

This flow shows that a thread can move back and forth between Runnable and Waiting
states depending on the situation.

## 4. WHY THIS MATTERS IN JAVA
Understanding thread life cycle helps developers:
- know when threads are active or inactive
- avoid unnecessary waiting
- understand scheduling behavior
- fix issues related to deadlock and starvation
- write more efficient concurrent programs

## 5. PSEUDOCODE FOR THREAD LIFE CYCLE
```text
BEGIN
    CREATE thread object
    STATE = NEW

    CALL start()
    STATE = RUNNABLE

    IF CPU allows execution THEN
        STATE = RUNNING
    ENDIF

    IF thread waits for resource THEN
        STATE = BLOCKED/WAITING
    ENDIF

    IF thread completes execution THEN
        STATE = TERMINATED
    ENDIF
END

```

### 6. PROGRAM 1: DEMONSTRATING THE THREAD LIFE CYCLE

**Headline:**
Understanding the States of a Java Thread

**Program:**

```java
class LifeCycleThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}

public class ThreadLifeCycleExample1 {
    public static void main(String[] args) {
        LifeCycleThread t1 = new LifeCycleThread();
        System.out.println("Thread state after creation: " + t1.getState());

        t1.start();
        System.out.println("Thread state after start(): " + t1.getState());

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state after completion: " + t1.getState());
    }
}

```

**Why this program is used:**

* It shows how to check the state of a thread at different points.
* It helps understand the transition of a thread through its lifecycle.
* It gives a practical example of using getState().

**How this helps Java:**

* It teaches developers how to monitor thread execution.
* It helps in debugging programs that involve concurrency.
* It clarifies the practical meaning of each thread state.

**Line-by-line explanation:**

1. class LifeCycleThread extends Thread {
* Creates a custom thread class.


2. public void run() {
* Defines the job of the thread.


3. for (int i = 1; i <= 3; i++) {
* Loops three times.


4. System.out.println("Thread is running: " + i);
* Prints the current value.


5. }
* Ends the loop.


6. }
* Ends run().


7. }
* Ends the custom thread class.


8. public class ThreadLifeCycleExample1 {
* Main class declaration.


9. public static void main(String[] args) {
* Entry point of the program.


10. LifeCycleThread t1 = new LifeCycleThread();
* Creates a thread object.


11. System.out.println("Thread state after creation: " + t1.getState());
* Prints the state when the thread is newly created.


12. t1.start();
* Starts execution of the thread.


13. System.out.println("Thread state after start(): " + t1.getState());
* Prints the state soon after calling start().


14. try {
* Begins exception handling block for join().


15. t1.join();
* Waits for thread t1 to complete.


16. } catch (InterruptedException e) {
* Handles interruption errors.


17. e.printStackTrace();
* Prints the error details.


18. }
* Ends catch block.


19. System.out.println("Thread state after completion: " + t1.getState());
* Prints the state after the thread has finished.


20. }
* Ends main.


21. }
* Ends class.



**Comments:**

```java
class LifeCycleThread extends Thread {
    // Custom thread class.
    public void run() {
        // Code executed when the thread starts.
        for (int i = 1; i <= 3; i++) {
            // Loop executes three times.
            System.out.println("Thread is running: " + i);
            // Prints the current loop count.
        }
    }
}

public class ThreadLifeCycleExample1 {
    // Main class.
    public static void main(String[] args) {
        // Program starts here.
        LifeCycleThread t1 = new LifeCycleThread();
        // Creates a thread object.
        System.out.println("Thread state after creation: " + t1.getState());
        // Prints the state after creation.

        t1.start();
        // Starts the thread.
        System.out.println("Thread state after start(): " + t1.getState());
        // Prints the state after start.

        try {
            // Try block for join.
            t1.join();
            // Waits until t1 finishes.
        } catch (InterruptedException e) {
            // Handles interruption.
            e.printStackTrace();
            // Prints error details.
        }

        System.out.println("Thread state after completion: " + t1.getState());
        // Prints state after thread ends.
    }
}

```

**Output example:**

```text
Thread state after creation: NEW
Thread state after start(): RUNNABLE
Thread is running: 1
Thread is running: 2
Thread is running: 3
Thread state after completion: TERMINATED

```

**Summary:**
This example shows how a thread moves from NEW to RUNNABLE and finally to TERMINATED.

### 7. PROGRAM 2: USING sleep() TO SHOW WAITING STATE

**Headline:**
How sleep() Affects the Thread Life Cycle

**Program:**

```java
public class ThreadLifeCycleExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread started");
                Thread.sleep(2000);
                System.out.println("Thread resumed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        System.out.println("Main thread is running");
    }
}

```

**Why this program is used:**

* It shows how a thread can temporarily pause its execution.
* It helps understand waiting behavior in the thread lifecycle.

**How this helps Java:**

* It explains why a thread may not run continuously.
* It shows how sleep() affects scheduling.

**Line-by-line explanation:**

1. Thread t1 = new Thread(() -> {
* Creates a new thread.


2. try {
* Starts a block that may throw an exception.


3. System.out.println("Thread started");
* Prints a message when the thread begins.


4. Thread.sleep(2000);
* Pauses thread execution for 2 seconds.


5. System.out.println("Thread resumed");
* Prints a message after waking up.


6. } catch (InterruptedException e) {
* Handles interruption exception.


7. e.printStackTrace();
* Prints exception details.


8. }
* Ends exception block.


9. });
* Ends lambda body.


10. t1.start();
* Starts the thread.


11. System.out.println("Main thread is running");
* Prints message from the main thread.



**Comments:**

```java
public class ThreadLifeCycleExample2 {
    // Program class.
    public static void main(String[] args) {
        // Execution starts here.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            try {
                // Tries to pause thread.
                System.out.println("Thread started");
                // Prints start message.
                Thread.sleep(2000);
                // Pauses execution for 2 seconds.
                System.out.println("Thread resumed");
                // Prints message after pause.
            } catch (InterruptedException e) {
                // Handles sleep interruption.
                e.printStackTrace();
                // Prints error details.
            }
        });

        t1.start();
        // Starts the thread.
        System.out.println("Main thread is running");
        // Prints a message in the main thread.
    }
}

```

**Output example:**

```text
Thread started
Main thread is running
Thread resumed

```

**Summary:**
This example shows that a thread can pause and later resume execution, which is part of its lifecycle behavior.

### 8. PROGRAM 3: DEMONSTRATING WAITING THROUGH join()

**Headline:**
Understanding Waiting Behavior with join()

**Program:**

```java
public class ThreadLifeCycleExample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Child thread: " + i);
            }
        });

        t1.start();
        t1.join();
        System.out.println("Main thread continues after child thread finishes");
    }
}

```

**Why this program is used:**

* It shows how one thread can wait for another thread to complete.
* It explains why a thread can be in a waiting state.

**How this helps Java:**

* It teaches coordination between multiple threads.
* It helps when one task depends on another task.

**Line-by-line explanation:**

1. Thread t1 = new Thread(() -> {
* Creates child thread.


2. for (int i = 1; i <= 3; i++) {
* Loop runs three times.


3. System.out.println("Child thread: " + i);
* Prints current value.


4. }
* Ends loop.


5. });
* Ends lambda expression.


6. t1.start();
* Starts the child thread.


7. t1.join();
* Waits for child thread to finish.


8. System.out.println("Main thread continues after child thread finishes");
* Prints message after join completes.



**Comments:**

```java
public class ThreadLifeCycleExample3 {
    // Program class.
    public static void main(String[] args) throws InterruptedException {
        // Main method may throw an exception.
        Thread t1 = new Thread(() -> {
            // Creates child thread.
            for (int i = 1; i <= 3; i++) {
                // Repeats three times.
                System.out.println("Child thread: " + i);
                // Prints each value.
            }
        });

        t1.start();
        // Starts the child thread.
        t1.join();
        // Waits for the child thread to finish.
        System.out.println("Main thread continues after child thread finishes");
        // Runs after the child thread completes.
    }
}

```

**Output:**

```text
Child thread: 1
Child thread: 2
Child thread: 3
Main thread continues after child thread finishes

```

**Summary:**
This example shows how join() makes one thread wait until another thread completes.

## 9. DIFFERENCE BETWEEN BLOCKED AND WAITING

Blocked:

* A thread is waiting because it cannot enter a synchronized block or method.
* It is waiting for a lock.

Waiting:

* A thread is waiting for another thread to notify it or for a timeout to happen.
* Example: using wait() or join().

## 10. COMMON THREAD LIFE CYCLE QUESTIONS

* What happens after a thread is started?
* When does a thread become Runnable?
* What causes a thread to move into Waiting state?
* How do we know that a thread is finished?

## 11. FINAL SUMMARY

The thread life cycle explains how a thread moves between different states during
its lifetime. Starting from NEW, it becomes RUNNABLE, then RUNNING, may enter WAITING
or BLOCKED states, and finally reaches TERMINATED. Understanding this flow is essential
for writing correct and efficient multithreaded Java programs.

## 12. PROFESSIONAL NOTE FOR REPOSITORY USE

This topic is ideal for a GitHub repository because it includes:

* theoretical explanation
* visual flow of states
* multiple code examples
* important method usage
* outputs and summaries

A good folder layout for this topic could be:

* theory/
* examples/
* code-output/
* notes/

```

```
