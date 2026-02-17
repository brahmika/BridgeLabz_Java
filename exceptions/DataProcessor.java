/*
 Problem Statement 6: Checked and Unchecked Exceptions
 Demonstrates both exception types.
*/
package exceptions;

import java.io.IOException;

public class DataProcessor {

    public void processData(String data) throws IOException {

        if (data == null) {
            throw new NullPointerException("Data is null.");
        }

        if (data.isEmpty()) {
            throw new IOException("Data is empty.");
        }

        System.out.println("Processing: " + data);
    }

    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor();

        try {
            dp.processData("");
        } catch (IOException e) {
            System.out.println("Checked: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Unchecked: " + e.getMessage());
        }
    }
}
