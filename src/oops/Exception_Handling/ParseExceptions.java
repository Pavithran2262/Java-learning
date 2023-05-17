package oops.Exception_Handling;

import java.text.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Scanner;

public class ParseExceptions {

        public static void main(String[] args) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false); // Set lenient parsing to false
            System.out.println("Enter date in the format \"dd-mm-yyyy\" :");
            Scanner sc = new Scanner(System.in);
            String dateString = sc.nextLine();
//            String dateString = "2023-05-17";
//            SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            try {
                // Attempt to parse the string into a date object
                dateFormat.parse(dateString);
                System.out.println("Parsing successful!");
            } catch (ParseException e) {
                System.out.println("Parsing failed: " + e.getMessage());
                System.out.println("Error index: " + e.getErrorOffset());
            }
        }


}
