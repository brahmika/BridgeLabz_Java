/*
 * Simple Threaded Counter Program
 *
 * This program demonstrates multithreading in Java by counting from 1 to a
 * user-defined limit using multiple threads. Each thread prints numbers in
 * sequential order through synchronized coordination using wait() and notifyAll().
 * Proper interrupt handling and error management ensure safe execution without
 * race conditions or deadlocks..
 */
import java.util.InputMismatchException;
import java.util.Scanner;

class Counter {

    private int current = 1;
    private final int limit;

    public Counter(int limit) {
        this.limit = limit;
    }

    public synchronized void printNumbers(int threadId, int totalThreads) {

        while (true) {

            // Exit condition FIRST (important fix)
            if (current > limit) {
                notifyAll(); // Wake others so they can exit
                break;
            }

            // Wait until it's this thread's turn
            while (current <= limit &&
                    (current - 1) % totalThreads != threadId) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; // Proper interrupt exit
                }
            }

            if (current <= limit) {
                System.out.println("Thread-" + threadId + " : " + current);
                current++;
                notifyAll();
            }
        }
    }
}

class CountingThread extends Thread {

    private final Counter counter;
    private final int threadId;
    private final int totalThreads;

    public CountingThread(Counter counter, int threadId, int totalThreads) {
        this.counter = counter;
        this.threadId = threadId;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run() {
        counter.printNumbers(threadId, totalThreads);
    }
}

public class SimpleThreadCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int limit;

        try {
            System.out.print("Enter counting limit: ");
            limit = scanner.nextInt();

            if (limit <= 0) {
                System.out.println("Limit must be positive.");
                return;
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        } finally {
            scanner.close();
        }

        int totalThreads = 3;
        Counter counter = new Counter(limit);

        CountingThread[] threads = new CountingThread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
            threads[i] = new CountingThread(counter, i, totalThreads);
            threads[i].start();
        }

        for (CountingThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Counting completed successfully.");
    }
}