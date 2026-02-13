/*
 * Reads a text file line by line using FileReader and BufferedReader.
 * Prints each line to the console and closes the file after reading.
 */

package linearsearch;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args){
        FileReader fr = null;
        BufferedReader br = null;

        try{

            fr = new FileReader("C:\\Users\\brahmika\\Desktop\\BridgeLabz_Java\\linearsearch\\Sample.txt");

            br = new BufferedReader(fr);

            String line;

            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println("Error reading file: "+ e.getMessage());
        } finally {
            try{
                if(br != null){
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e){
                System.out.println("Error closing it");
            }
        }
    }
}
