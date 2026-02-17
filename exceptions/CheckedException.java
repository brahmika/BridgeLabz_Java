/*
 Reads file "data.txt".
 If file exists, prints contents.
 If not, handles IOException and prints "File not found".
*/
package exceptions;

import java.io.*;

public class CheckedException {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
