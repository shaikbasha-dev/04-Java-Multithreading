/*
 * =============================================================================
 * Program Name  : Creating Thread by Extending Thread Class
 * Description   : Demonstrates how to create a thread by extending the Thread
 *                 class and overriding its run() method.
 *
 * Author        : Shaik Mahaboob Basha
 * Repository    : 04-Java-Multithreading
 * GitHub        : https://github.com/shaikbasha-dev
 * =============================================================================
 */

// Declares a class named MyThread that extends the Thread class.
class MyThread extends Thread {

    // Overrides the run() method that contains the task to be executed by the thread.
    @Override
    public void run() {

        // Displays a message indicating that the child thread has started.
        System.out.println("Child Thread Started");

        // Executes the loop five times.
        for (int i = 1; i <= 5; i++) {

            // Displays the current iteration executed by the child thread.
            System.out.println("Child Thread : " + i);
        }

        // Displays a message indicating that the child thread has completed.
        System.out.println("Child Thread Finished");
    }
}

// Declares the main class.
public class CreatingThreadByExtendingThreadClass {

    // The main() method is the entry point of the Java application.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Starts the execution of the child thread.
        thread.start();

        // Displays a message indicating that the main thread continues its execution.
        System.out.println("Main Thread Continues...");

        // Displays a message indicating that the main thread has completed.
        System.out.println("Main Thread Finished");
    }
}
