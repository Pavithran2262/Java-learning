package oops.Exception_Handling;
import java.lang.*;
import java.io.*;
public class FileNotFoundExceptions {

        public static void main(String[] args) {
            try {
                readFile("acd.txt");
            } catch (IOException e) {
                System.out.println("File not found: " + e.getMessage());
            }
//            catch (FileNotFoundException f){
//                System.out.println("File not found: " + f.getMessage());
//            }
        }
        public static void readFile(String filename) throws FileNotFoundException,IOException {
            FileReader fileReader = new FileReader(filename);
            // Perform file operations
            fileReader.close();
        }
    }


