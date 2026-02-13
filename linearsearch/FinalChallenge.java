/*
 * Finds the first missing positive integer using index marking.
 * Returns the smallest positive number not present in the array.
 */

package linearsearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinalChallenge {

    public static void main(String[] args) {

        testStringPerformance();
        testFileReadingPerformance("C:\\Users\\brahmika\\Desktop\\BridgeLabz_Java\\linearsearch\\Sample.txt");
    }
    public static void testStringPerformance() {

        List<String> list = new ArrayList<>();
        list.add("Hello");

        int iterations = 1000000;

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < iterations; i++) {
            for (String s : list) {
                sb.append(s);
            }
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();

        for (int i = 0; i < iterations; i++) {
            for (String s : list) {
                sbuffer.append(s);
            }
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        System.out.println("StringBuilder Time (ns): " + builderTime);
        System.out.println("StringBuffer Time (ns):  " + bufferTime);
    }

    public static void testFileReadingPerformance(String fileName) {

        long wordCount = 0;

        try {

            long startFileReader = System.currentTimeMillis();
            BufferedReader br1 = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br1.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }

            br1.close();

            long endFileReader = System.currentTimeMillis();
            long fileReaderTime = endFileReader - startFileReader;

            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time (ms): " + fileReaderTime);

            wordCount = 0;

            long startInputStream = System.currentTimeMillis();

            BufferedReader br2 =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(fileName), "UTF-8"));

            while ((line = br2.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }

            br2.close();

            long endInputStream = System.currentTimeMillis();
            long inputStreamTime = endInputStream - startInputStream;

            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time (ms): " + inputStreamTime);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
