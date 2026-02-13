
/*
 * Compares performance of Recursive (O(2^n))
 * and Iterative (O(n)) Fibonacci implementations.
 */
package algorithms;
import java.util.*;

public class FibonacciComparision {

    // Recursive Fibonacci (Exponential time complexity)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear time complexity)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        int n = 30;  // Change value to test different inputs

        // Measure Recursive time
        long startRecursive = System.currentTimeMillis();
        int resultRecursive = fibonacciRecursive(n);
        long endRecursive = System.currentTimeMillis();

        // Measure Iterative time
        long startIterative = System.currentTimeMillis();
        int resultIterative = fibonacciIterative(n);
        long endIterative = System.currentTimeMillis();

        // Display results
        System.out.println("Fibonacci Number for n = " + n);
        System.out.println("Recursive Result: " + resultRecursive);
        System.out.println("Recursive Time (ms): " + (endRecursive - startRecursive));
        System.out.println("Iterative Result: " + resultIterative);
        System.out.println("Iterative Time (ms): " + (endIterative - startIterative));
    }
}
