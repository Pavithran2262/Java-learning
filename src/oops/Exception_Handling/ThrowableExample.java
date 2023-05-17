package oops.Exception_Handling;

import java.util.Scanner;

public class ThrowableExample {
        public static void main(String[] args) {
            System.out.println("Enter Age to check Eligibility for Voter ID :");
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            try {
                String result = check(age);
                System.out.println("Eligibility Status : " + result);
            } catch (Throwable t) {
                System.out.println("An exception occurred: " + t.getMessage());
                t.printStackTrace();
            }
        }

        public static String check(int age) throws Throwable {
            if (age<=17) {
                throw new Throwable("Minimum Age requirement for get voter ID is 18,so You are not eligible.....");
            }
            return "Eligible";
        }


}
