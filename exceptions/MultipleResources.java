/*
 Problem Statement 4: Try-With-Resources with Multiple Resources
 Reads from two files and writes combined content into a third file.
 All resources are auto-closed properly.
*/
package exceptions;

import java.io.*;

public class MultipleResources {

    public void mergeFiles(String file1, String file2, String outputFile) {

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;

            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Files merged successfully.");

        } catch (IOException e) {
            System.out.println("Error during file merge: " + e.getMessage());
        }
    }
}
