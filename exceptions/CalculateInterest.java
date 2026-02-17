package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CalculateInterest {
    static class FileProcessor {

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
}
