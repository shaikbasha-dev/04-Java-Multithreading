# 08 - Thread Priority in Java

## TOPIC OVERVIEW
Thread priority is a concept that helps the Java scheduler decide which thread
should be given more CPU time compared to other threads. In Java, every thread has
an integer priority value, and higher-priority threads are generally preferred by
the scheduler.

**Why this topic is important:**
- It helps understand how Java schedules threads.
- It allows developers to influence execution order in some cases.
- It is commonly asked in interviews and exams.
- It creates a foundation for understanding performance and scheduling behavior.

## 1. DEFINITION OF THREAD PRIORITY
Thread priority defines the relative importance of a thread compared to other threads.
It is used by the Java scheduler to decide which thread should run first, but it does
not guarantee exact execution order.

A thread priority is an integer value between:
- Thread.MIN_PRIORITY (1)
- Thread.NORM_PRIORITY (5)
- Thread.MAX_PRIORITY (10)

## 2. DEFAULT PRIORITY OF A THREAD
If you do not set a thread priority manually, Java gives the thread the default
priority value:

Thread.NORM_PRIORITY

This value is 5.

## 3. WHY PRIORITY EXISTS
Priority exists because some tasks may be more important than others.
For example:
- A user interface thread may need more immediate attention.
- A background task may run with lower priority.

However, the final result still depends on the operating system and JVM scheduler.

## 4. IMPORTANT POINTS ABOUT PRIORITY
- Priority is only a hint to the scheduler.
- It is not guaranteed that a higher-priority thread will always run first.
- The scheduler may still choose another thread based on the system environment.
- Priority values are relative, not absolute.

## 5. METHODS RELATED TO PRIORITY
- setPriority(int priority)
  - Sets the priority of the thread.

- getPriority()
  - Returns the priority of the thread.

- Thread.MIN_PRIORITY
  - Minimum value = 1

- Thread.NORM_PRIORITY
  - Normal value = 5

- Thread.MAX_PRIORITY
  - Maximum value = 10

## 6. PSEUDOCODE FOR THREAD PRIORITY
```text
BEGIN
    CREATE thread object
    SET thread priority
    START thread
    GET thread priority
    DISPLAY result
END

```

### 7. PROGRAM 1: SETTING AND GETTING THREAD PRIORITY

**Headline:**
Using setPriority() and getPriority()

**Program:**

```java
public class ThreadPriorityExample1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
        }, "WorkerThread");

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority before start: " + t1.getPriority());
        t1.start();
    }
}

```

**Why this program is used:**

* It shows how to set and retrieve thread priority.
* It explains the difference between before and after starting a thread.

**How this helps Java:**

* It teaches how to control thread importance.
* It helps developers understand how thread metadata is used.

**Line-by-line explanation:**

1. public class ThreadPriorityExample1 {
* Declares the main class.


2. public static void main(String[] args) {
* Starts the program.


3. Thread t1 = new Thread(() -> {
* Creates a new thread.


4. System.out.println("Thread name: " + Thread.currentThread().getName());
* Prints the current thread's name.


5. System.out.println("Thread priority: " + Thread.currentThread().getPriority());
* Prints the current thread's priority.


6. }, "WorkerThread");
* Gives the thread the name WorkerThread.


7. t1.setPriority(Thread.MAX_PRIORITY);
* Sets the thread priority to 10.


8. System.out.println("Priority before start: " + t1.getPriority());
* Prints the priority before thread starts.


9. t1.start();
* Starts the thread.


10. }
* Ends main.


11. }
* Ends class.



**Comments:**

```java
public class ThreadPriorityExample1 {
    // Main class.
    public static void main(String[] args) {
        // Execution starts here.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            System.out.println("Thread name: " + Thread.currentThread().getName());
            // Prints the current thread name.
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
            // Prints the current thread priority.
        }, "WorkerThread");
        // Names the thread WorkerThread.

        t1.setPriority(Thread.MAX_PRIORITY);
        // Sets the priority to the highest possible value.
        System.out.println("Priority before start: " + t1.getPriority());
        // Prints the set priority.
        t1.start();
        // Starts the thread.
    }
}

```

**Output:**

```text
Priority before start: 10
Thread name: WorkerThread
Thread priority: 10

```

**Summary:**
This program shows how to set, retrieve, and use thread priority values.

### 8. PROGRAM 2: COMPARING DIFFERENT THREAD PRIORITIES

**Headline:**
Understanding Priority Differences Between Threads

**Program:**

```java
public class ThreadPriorityExample2 {
    public static void main(String[] args) {
        Thread low = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Low priority thread: " + i);
            }
        }, "LowThread");

        Thread high = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("High priority thread: " + i);
            }
        }, "HighThread");

        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        high.start();
    }
}

```

**Why this program is used:**

* It compares low-priority and high-priority threads.
* It helps explain that scheduling is influenced by priority.

**How this helps Java:**

* It teaches how developers can influence scheduling behavior.
* It makes the concept of priority easier to understand.

**Line-by-line explanation:**

1. Thread low = new Thread(() -> {
* Creates a low-priority thread.


2. for (int i = 1; i <= 5; i++) {
* Loop runs five times.


3. System.out.println("Low priority thread: " + i);
* Prints message from low-priority thread.


4. }
* Ends loop.


5. }, "LowThread");
* Gives the thread the name LowThread.


6. Thread high = new Thread(() -> {
* Creates a high-priority thread.


7. for (int i = 1; i <= 5; i++) {
* Loop runs five times.


8. System.out.println("High priority thread: " + i);
* Prints message from high-priority thread.


9. }
* Ends loop.


10. }, "HighThread");
* Gives the thread the name HighThread.


11. low.setPriority(Thread.MIN_PRIORITY);
* Assigns the minimum priority to the low thread.


12. high.setPriority(Thread.MAX_PRIORITY);
* Assigns the maximum priority to the high thread.


13. low.start();
* Starts the low-priority thread.


14. high.start();
* Starts the high-priority thread.



**Comments:**

```java
public class ThreadPriorityExample2 {
    // Program class.
    public static void main(String[] args) {
        // Main method starts execution.
        Thread low = new Thread(() -> {
            // Creates low-priority thread.
            for (int i = 1; i <= 5; i++) {
                // Loop runs five times.
                System.out.println("Low priority thread: " + i);
                // Prints output for low-priority thread.
            }
        }, "LowThread");
        // Names the thread LowThread.

        Thread high = new Thread(() -> {
            // Creates high-priority thread.
            for (int i = 1; i <= 5; i++) {
                // Loop runs five times.
                System.out.println("High priority thread: " + i);
                // Prints output for high-priority thread.
            }
        }, "HighThread");
        // Names the thread HighThread.

        low.setPriority(Thread.MIN_PRIORITY);
        // Sets low priority.
        high.setPriority(Thread.MAX_PRIORITY);
        // Sets high priority.

        low.start();
        // Starts low-priority thread.
        high.start();
        // Starts high-priority thread.
    }
}

```

**Output example:**

```text
High priority thread: 1
High priority thread: 2
High priority thread: 3
High priority thread: 4
High priority thread: 5
Low priority thread: 1
Low priority thread: 2
Low priority thread: 3
Low priority thread: 4
Low priority thread: 5

```

**Summary:**
This program shows how high-priority threads are often preferred by the scheduler.

### 9. PROGRAM 3: USING NORM_PRIORITY

**Headline:**
Understanding Default Priority Behavior

**Program:**

```java
public class ThreadPriorityExample3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Default priority: " + Thread.currentThread().getPriority());
        });

        t1.start();
    }
}

```

**Why this program is used:**

* It demonstrates the default priority value.
* It helps learners understand what happens when no priority is set.

**How this helps Java:**

* It shows the baseline behavior of threads.
* It teaches the default scheduling range.

**Line-by-line explanation:**

1. Thread t1 = new Thread(() -> {
* Creates a thread.


2. System.out.println("Default priority: " + Thread.currentThread().getPriority());
* Prints the thread's priority.


3. });
* Ends lambda expression.


4. t1.start();
* Starts the thread.



**Comments:**

```java
public class ThreadPriorityExample3 {
    // Main program class.
    public static void main(String[] args) {
        // Execution starts here.
        Thread t1 = new Thread(() -> {
            // Creates a thread.
            System.out.println("Default priority: " + Thread.currentThread().getPriority());
            // Prints the default priority.
        });

        t1.start();
        // Starts the thread.
    }
}

```

**Output:**

```text
Default priority: 5

```

**Summary:**
This program shows that a thread without a manually set priority uses the default value 5.

## 10. IMPORTANT NOTE ABOUT PRIORITY NOT BEING GUARANTEED

Even if one thread has a higher priority, Java does not guarantee that it will always
run first. The exact behavior depends on:

* the JVM implementation
* the operating system scheduler
* the current system load
* other background processes

This means that priority is useful but should not be treated as a strict rule.

## 11. FINAL SUMMARY

Thread priority in Java is a way to give threads different levels of importance.
The priority values range from 1 to 10, with 5 being the default. Methods like
setPriority() and getPriority() allow us to inspect and modify these values. Although
priority can influence scheduling, it does not guarantee exact execution order.

## 12. PROFESSIONAL NOTE FOR REPOSITORY USE

This topic is ideal for a GitHub repository because it covers:

* definition and theory
* practical examples
* precise explanations of methods
* comments for each line
* sample outputs and summaries

A good structure for this topic is:

* theory/
* examples/
* outputs/
* notes/

```

```
