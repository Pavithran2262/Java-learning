package Bank;
import java.util.*;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Iterator;
//import java.util.Scanner;
import java.lang.*;

public class Main {
    public static ArrayList<User> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Banking Application...");
        loginPage();
    }

    public static void loginPage() {
        System.out.println("Login Page\n     Type 1 for Signin (Existing user)\n     Type 2 for Signup (New User)");
        System.out.println("     Type 3 to Exit");
        System.out.println("Type here : ");
        Scanner sc = new Scanner(System.in);
        int input = 0;
        do {
            try {
//                System.out.println("Invalid input. Please enter 1 to 3 : ");
                input = Integer.parseInt(sc.next());
                sc.nextLine(); // Consume the newline character
            } catch (NumberFormatException e) {
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

        public static void newUser() {
        System.out.println("CREATE THE NEW ACCOUNT HERE ");
        Scanner scn = new Scanner(System.in);
        String uname, pwd;
        int w=0;
        do{
            System.out.println("Enter the Username : ");
            uname = scn.nextLine();
          }while (uname.isEmpty());
            for(User t: list){
                if(t.getname().equals(uname)){
                    while(w==0) {
                        do {
                            System.out.println("User Already exist , Please enter different Username : ");
                            uname = scn.nextLine();
                        } while (t.getname().equals(uname));
                        w++;
                    }
                    break;
                }
            }

            do{
                System.out.println("Enter the Password : ");
                pwd = scn.nextLine();
            } while (pwd.isEmpty());
            System.out.println("Enter the Initial amount that must be more than 2500 : ");
            double inibal = 0.0;
            do {
//            inibal = sc.nextDouble();

                try {
                    inibal = Double.parseDouble(scn.next());
                    scn.nextLine();
//   sc.nextLine(); // Consume the newline character
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter the amount more than 2500 : ");
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter the amount more than 2500 : ");
                    continue;
                }

                if (inibal < 2500) {
                    System.out.println("Please Enter the Initial amount more than 2500 : ");
                }
            } while (inibal < 2500);
//            us2.deposit(inibal);
            list.add(new User(uname, pwd, inibal));
            System.out.println("Now you can login ");
            existingUser();
        }
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
                    System.out.print("Enter the amount you want to deposit : ");
                    double amount2;
                    Scanner sc2 = new Scanner(System.in);
                    amount2 = sc2.nextDouble();
                    for (User us2 : list) {
                        if (us2.getIndex() == indexnum) {
                            while (amount2 > us2.getBalance()) {
                                amount2 = sc2.nextDouble();
                            }
                            us2.deposit(amount2);
                        }

                    }
                    loggedin(indexnum);
                } else if (choice == 3) {
                    System.out.print("Enter the amount you want to withdraw : ");
                    double amount3;
                    Scanner sc3 = new Scanner(System.in);
                    amount3 = sc3.nextDouble();
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
        private static void transferOperation ( int index){
            Scanner sc1 = new Scanner(System.in);
            int temp =0;
            while(temp==0) {
                System.out.print("Enter the Account Number you want to send money : ");
                double toAccountNumber = sc1.nextDouble();
                for (User us : list) {
                    if (us.getIndex() == index) {

                        Iterator<User> abc = list.iterator();
                        while (abc.hasNext()) {
                            User u = abc.next();
                            if (u.getac_no() == toAccountNumber) {
                                temp++;
                                System.out.print("Enter the amount to Transfer: ");
                                double amount = sc1.nextDouble();
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
                    System.out.println("For go back Press 1 or press 2 for continue : ");
                    w = sc1.nextInt();
                }while(w<1||w>2);
                if(w==1){
                    loggedin(index);
                    break;
                }
            }
            loggedin(index);
        }

}


