/*
 * Compares execution time of StringBuilder and StringBuffer.
 * Measures concatenation speed using System.nanoTime().
 */

package linearsearch;

public class StringComparison {
    public static void main(String[] args){
        int iterations = 1000000;
        StringBuffer sb = new StringBuffer();
        long startBuffer = System.nanoTime();

        for(int i = 0; i < iterations; i++){
            sb.append("hello");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        StringBuilder sbuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for(int i = 0; i < iterations; i++){
            sbuilder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by String Buffer: "+ timeBuffer);
        System.out.println("Time taken by StringBUilder: "+timeBuilder);
    }
}
