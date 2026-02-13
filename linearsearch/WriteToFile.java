/*
 * Reads user input from console using InputStreamReader.
 * Writes each line to a file until user enters "exit".
 */

package linearsearch;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class WriteToFile {
    public static void main(String[] args){
        BufferedReader br = null;
        FileWriter fw = null;

        try{

            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            fw = new FileWriter("linearsearch/output.txt");

            String input;

            System.out.println("Enter text (type 'exit' to stop)");

            while(true) {
                input = br.readLine();
                if(input.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(input);
                fw.write("\n");
            }
            System.out.println("Data written successfully");
        } catch (IOException e){
            System.out.println("Error" + e.getMessage());
        } finally {
            try{
                if(fw != null){
                    fw.close();
                }
                if (br != null){
                    br.close();
                }
            }catch (IOException e){
                System.out.println("Error closing resources");
            }
        }
    }
}
