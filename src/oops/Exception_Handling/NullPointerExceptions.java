package oops.Exception_Handling;

public class NullPointerExceptions {
        public static void main(String[] args) {
            System.out.println("HI");
            String text = null;

            try {
                int length = text.length(); // Attempting to access length() method on a null reference
                System.out.println("Length of text: " + length);
            } catch (NullPointerException e) {
//                e.printStackTrace();
                System.out.println("NullPointerException occurred: " + e.getMessage());
            }
        }

}

