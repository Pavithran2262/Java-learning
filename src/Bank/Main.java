package Bank;
import java.sql.SQLException;
import java.util.*;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Iterator;
//import java.util.Scanner;
import java.lang.*;


/* The main Class used to navigate the user to the login page then through the input, create the account or
 logged into account and they are allowed to do Withdraw ,deposit and transfer Actions*/
public class Main {
    public static ArrayList<User> list = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Banking Application...");
        loginPage();
    }

   /*The loginpage() method used to get input from user and navigate to signin or signup method
   depending upon the user input */
    public static void loginPage() {

        Scanner sc = new Scanner(System.in);
        int input = 0;
        do {
            try {
                System.out.println("Login Page\n     Type 1 for Signin (Existing user)\n     Type 2 for Signup (New User)");
                System.out.println("     Type 3 to Exit");
                System.out.println("Type here : ");
                input = Integer.parseInt(sc.next());
                sc.nextLine(); // Consume the newline character
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 to 3 : ");
            }
            catch (InputMismatchException i){
                System.out.println("Invalid input. Please enter 1 to 3 : ");
            }
        } while (input < 1 || input > 3);
           switch (input) {
            case 1:
                existingUser();
                break;
            case 2:
                newUser();
                break;
            case 3:
                System.out.println("Thank You for using our Banking service...");
                System.exit(0);

           }
    }

    /* The newUser method used for create the account for New User by receive the new User that
    is not match to existing customer , password and Initial amount (>2500) */
        public static void newUser() {
        System.out.println("CREATE THE NEW ACCOUNT HERE ");
        Scanner scn = new Scanner(System.in);
        String uname, pwd;
//        int w=0;
        do{
            System.out.println("Enter the Username  : ");
            uname = scn.nextLine();
          }while (uname.isEmpty());
            for(User t: list){
                if(t.getname().equals(uname)){
//                    while(w==0) {
                        do {
                            System.out.println("User Already exist , Please enter different Username : ");
                            uname = scn.nextLine();
                        } while (t.getname().equals(uname));
//                        w++;
//                    }
                    break;
                }
            }

            do{
                System.out.println("Enter the Password : ");
                pwd = scn.nextLine();
            } while (pwd.isEmpty());
            System.out.println("Enter the Initial amount that must be more than 2500 : ");
            double inibal = 0.0;    //Initial balance
            do {
                try {
                    inibal = Double.parseDouble(scn.next());
                    scn.nextLine();
                }
//                catch (InputMismatchException e) {
//                    System.out.println("Invalid input. Please enter the amount more than 2500 : ");
//                    continue;
//                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter the amount more than 2500 : ");
                    continue;
                }

                if (inibal < 2500) {
                    System.out.println("Please Enter the Initial amount more than 2500 : ");
                }
            } while (inibal < 2500);
//            us2.deposit(inibal);
//            User user1 = new User(uname,pwd,inibal);
            try {
                list.add(new User(uname, pwd, inibal));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Now you can login ");
            existingUser();
        }

        /* The existingUser method is used to verify the customer credential and allow them to login via
        username and password */
        public static void existingUser () {
            System.out.println("Enter the Username : ");
            Scanner sc = new Scanner(System.in);
            String Uname = sc.nextLine();
            System.out.println("Enter the Password : ");
            String Pwd = sc.nextLine();
            int check = 0;
            int indexnum = -1;
            Iterator<User> abc = list.iterator();
            while (abc.hasNext()) {
                User u = abc.next();
                if (Uname.equals(u.getname()) && Pwd.equals(u.getPassword())) {
                    indexnum = u.index;
                    System.out.println("Hi " + u.getname()+" Welcome to our Banking Service...");
                    check++;
                }
            }
            if (check == 1) {
                loggedin(indexnum);
            } else {
                System.out.println("User name or password is incorrect \n     Press 1 for Try again \n     Press 2 for Go back ");
                System.out.println("Type here : ");
                int input = 0;
                do {
                    try {
                        input = Integer.parseInt(sc.next());
                        sc.nextLine(); // Consume the newline character
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter 1 or 2 : ");
                    }
                } while (input < 1 || input > 2);
                if (input == 1) {
                    existingUser();
                } else {
                    loginPage();
                }
            }
        }

        /* The method loggedin used to display the content after login to their account and navigate
        to the Withdrawal , deposit or tranfer section */
        public static void loggedin ( int indexnum){
            while (true) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("\n--- Banking Application Menu ---");
                System.out.println("1. Get Account Details");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Money");
                System.out.println("5. View Transaction Details");
                System.out.print("6. Log Out \n     Type here : ");
                int choice = 0;
                do {
                    try {
                        choice = Integer.parseInt(sc1.next());

                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. Please enter 1 to 6 : ");
                    }
                } while (choice < 1 || choice > 6);
                sc1.nextLine(); // Consume the newline character

                if (choice == 1) {
                    Iterator<User> abc = list.iterator();
                    while (abc.hasNext()) {
                        User u = abc.next();
                        if (u.index == indexnum) {
                            System.out.println("Account Holder Number : " + u.getname());
                            System.out.println("Account Number : " + u.getac_no());
                            System.out.println("Balance : " + u.getBalance());
                        }
                    }
                    loggedin(indexnum);
                } else if (choice == 2) {
                    double amount2;
                    Scanner sc2 = new Scanner(System.in);
                    do {
                        while (true) {
                            try {
                                System.out.print(" \nPlease enter amount to Deposit : ");
                                amount2 = Double.parseDouble(sc2.next());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.print("Invalid input.");
                                sc2.nextLine(); // Consume the newline character
                            }
                        }
                    }while(amount2<1);
//                    amount2 = sc2.nextDouble();
                    for (User us2 : list) {
                        if (us2.getIndex() == indexnum) {
                            us2.deposit(amount2);
                        }

                    }
                    loggedin(indexnum);
                } else if (choice == 3) {
                    double amount3;
                    Scanner sc3 = new Scanner(System.in);
                    do {
                        while (true) {
                            try {
                                System.out.print("Enter the amount you want to withdraw : ");
                                amount3 = sc3.nextDouble();
                                sc3.nextLine();
                                break;

                            } catch (InputMismatchException e) {
                                System.out.print("Invalid input.");
                                sc3.nextLine();
                            } catch (NumberFormatException r) {
                                System.out.print("Invalid input.");
                                sc3.nextLine();
                            }
                        }
                    }while(amount3<1);
                    for (User us3 : list) {
                        if (us3.getIndex() == indexnum) {
                            double as = us3.getBalance() - 500;
                            while (amount3 > as) {
                                System.out.println("Insufficient Balance \nPlease enter the amount below " + as + " because minimum Account balance is 500");
                                amount3 = sc3.nextDouble();
                            }
                            us3.withdraw(amount3);
                        }
                    }
                    loggedin(indexnum);
                } else if (choice == 4) {
                    transferOperation(indexnum);
                } else if (choice == 5) {
                    for (User us2 : list) {
                        if (us2.getIndex() == indexnum) {
                            us2.getTransactionHistory();
                            break;
                        }
                    }
                    loggedin(indexnum);
                } else {
                    loginPage();
                }
            }
        }
    /* transferOperation() method used to verify the receiving account number , limit the tranfer amount
        to maintain minimum balance of 500 and call the tranfer function */
        private static void transferOperation ( int index){
            Scanner sc1 = new Scanner(System.in);
            int temp =0;
            while(temp==0) {
                double toAccountNumber =0;
                while(true) {
                    try {
                        System.out.print("\nEnter the Account Number you want to send money : ");
                        toAccountNumber = Double.parseDouble(sc1.next());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input.");
                        sc1.nextLine();// Consume the newline character
                    }
                }
                for (User us : list) {
                    if (us.getIndex() == index) {

                        Iterator<User> abc = list.iterator();
                        while (abc.hasNext()) {
                            User u = abc.next();
                            if (u.getac_no() == toAccountNumber) {
                                temp++;
                                double amount;
                                do {
                                    while (true) {
                                        try {
                                            System.out.print("\nEnter the amount to Transfer: ");
                                            amount = Double.parseDouble(sc1.next());
                                            break;
                                        } catch (NumberFormatException e) {
                                            System.out.print("Invalid input.");
                                            sc1.nextLine(); // Consume the newline character
                                        }
                                    }
                                }while(amount<1);
                                double aa = us.getBalance() - 500;
                                while (amount > aa) {
                                    System.out.println("Minimum Account balance is 500 . so Please enter the amount below " + aa);
                                    amount = sc1.nextDouble();
                                }
                                us.transfer(u, amount);
                                u.history.add("Received : " + amount+" from Account number "+us.getac_no() ) ;
                                break;
                            }
                        }
                        break;
                    }
                }
                int w = 0 ;
                if(temp==1){
                    break;
                }
                else if(temp==0){
                    System.out.println("Incorrect Account number!...");
                }
                do {
                        try {
                            System.out.println("For go back Press 1 or press 2 for continue : ");
                            w= Integer.parseInt(sc1.next());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input.");
                            sc1.nextLine(); // Consume the newline character
                        }
                }while(w<1||w>2);
                if(w==1){
                    loggedin(index);
                    break;
                }
            }
            loggedin(index);
        }

}


