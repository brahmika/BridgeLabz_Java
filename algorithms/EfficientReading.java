package algorithms;
import java.io.*;
/*
     * Compares performance of FileReader (Character Stream)
     * and InputStreamReader (Byte Stream) for large file reading.
     */
public class EfficientReading {

    public static void main(String[] args) throws Exception {

        String filePath = "largefile.txt";

        // Using FileReader (character stream)
        long startFileReader = System.currentTimeMillis();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1) {
            // Reading character by character
        }
        fr.close();
        long endFileReader = System.currentTimeMillis();

        // Using InputStreamReader (byte stream converted to characters)
        long startInputStreamReader = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1) {
            // Reading byte stream and converting to characters
        }
        isr.close();
        long endInputStreamReader = System.currentTimeMillis();

        // Display execution time
        System.out.println("FileReader Time (ms): " + (endFileReader - startFileReader));
        System.out.println("InputStreamReader Time (ms): " + (endInputStreamReader - startInputStreamReader));
    }
}

