    /*
     * Compares performance of String (O(N²)),
     * StringBuilder (O(N)), and StringBuffer (O(N))
     * for large string concatenation.
     */

    package algorithms;

public class StringConcatenation {

    public static void main(String[] args) {

        int iterations = 1_000_000; // Number of concatenations
        String text = "hello";

        // Using String (Immutable - creates new object every time)
        long startString = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str = str + text;
        }
        long endString = System.nanoTime();

        // Using StringBuilder (Mutable - fast, not thread-safe)
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endBuilder = System.nanoTime();

        // Using StringBuffer (Mutable - thread-safe)
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endBuffer = System.nanoTime();

        // Display execution times in milliseconds
        System.out.println("Operations: " + iterations);
        System.out.println("String Time (ms): " + (endString - startString) / 1_000_000);
        System.out.println("StringBuilder Time (ms): " + (endBuilder - startBuilder) / 1_000_000);
        System.out.println("StringBuffer Time (ms): " + (endBuffer - startBuffer) / 1_000_000);
    }
}
