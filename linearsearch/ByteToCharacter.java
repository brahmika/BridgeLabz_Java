/*
 * Converts byte stream to character stream using InputStreamReader.
 * Reads file with specified charset (e.g., UTF-8) and prints content.
 */

package linearsearch;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ByteToCharacter {
    public static void main(String[] args){
            String fileName = "C:\\Users\\brahmika\\Desktop\\BridgeLabz_Java\\linearsearch\\Sample.txt";

            try {
                FileInputStream fis = new FileInputStream(fileName);

                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

                BufferedReader br = new BufferedReader(isr);

                String line;

                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
                br.close();
                isr.close();
                fis.close();
            } catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }
    }
}
