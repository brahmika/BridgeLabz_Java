/*
 Problem Statement 1: Try-With-Resources
 This class reads multiple files using BufferedReader.
 It ensures each file is automatically closed using try-with-resources.
 IOException is properly handled during file processing.
*/
package exceptions;

import java.io.*;
import java.util.*;

class FileProcessor {

    public void processFiles(List<String> filePaths) {
        for (String path : filePaths) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                System.out.println("Reading file: " + path);
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + path + " -> " + e.getMessage());
            }
        }
    }
}
