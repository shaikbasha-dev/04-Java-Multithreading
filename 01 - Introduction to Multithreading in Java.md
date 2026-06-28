# 01 - Introduction to Multithreading in Java

### 1. What is Multithreading?
- Multithreading means running multiple threads in a single process.
- A thread is the smallest unit of execution inside a program.
- It allows a program to do more than one task at the same time.

### 2. Process vs Thread
- Process: a running program with its own memory space.
- Thread: a lightweight unit inside a process that shares memory with other threads.
- Example: a web browser is a process, and each tab may run in a separate thread.

### 3. Why Use Multithreading?
- Improves performance on multi-core CPUs.
- Keeps the application responsive.
- Helps perform background tasks without blocking the main flow.
- Useful for tasks like file I/O, networking, animations, and server requests.

### 4. Concurrency vs Parallelism
- Concurrency: multiple tasks make progress over time.
- Parallelism: multiple tasks run at the exact same time on different CPU cores.
- A program can be concurrent without being fully parallel.

### 5. Java Thread Model
- Java supports multithreading using the Thread class and Runnable interface.
- Every Java program starts with one main thread.
- You can create extra threads to run code independently.

### 6. Creating Threads in Java

Method 1: Extending Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main thread");
    }
}

Method 2: Implementing Runnable interface
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        t1.start();
    }
}

### 7. start() vs run()
- start(): creates a new thread and runs the task asynchronously.
- run(): just calls the method normally on the current thread.
- Always use start() to begin a new thread.

### 8. Important Thread Methods
- sleep(long milliseconds): pauses the current thread.
- join(): waits for another thread to finish.
- yield(): gives chance to another thread to run.
- setPriority(): sets thread priority.

### 9. Thread Life Cycle
A thread can be in one of these states:
- New
- Runnable
- Running
- Blocked/Waiting
- Terminated

### 10. Challenges in Multithreading
- Race conditions
- Deadlock
- Starvation
- Visibility issues
- Data inconsistency

### 11. Synchronization
- Synchronization is used to control access to shared resources.
- It avoids multiple threads modifying the same data at the same time.

### Example:
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

### 12. Summary
- Multithreading allows multiple tasks to run concurrently.
- It helps improve responsiveness and performance.
- Java provides built-in support using Thread and Runnable.
- Synchronization is important for safe shared data access.

### 13. Simple Example
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        t1.start();
        t2.start();
    }
}

### 14. Key Takeaway
- Multithreading is powerful, but it must be used carefully.
- Understanding thread lifecycle and synchronization is essential for writing correct programs.
