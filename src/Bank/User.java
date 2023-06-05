package Bank;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

//import static Bank.Main.list;

public class User extends Main {
//    String url = "jdbc:mysql://localhost:3306/Banking";
//    String system_name = "root";
//    String passvord = "Postgresql@123";
//
//    Connection con = DriverManager.getConnection(url,system_name,passvord);
//    Statement st = con.createStatement();



    private String name ;
    private double ac_no ;
    private String password;
    private double balance ;
    public ArrayList<String> history;
    static int count;

    protected int index ;

    static {
        count = 0;
    }
    //this User Constructor used to initialize the user object with proper information
    public User(String accountHolderName , String passwordd , double inibal) throws SQLException {
        this.ac_no = random();
        this.name = accountHolderName;
        this.password = passwordd;
        this.balance = inibal;
        this.index = count;
        this.history = new ArrayList<>();
        count ++;
        System.out.println("Hi "+this.getname()+" your Account number is "+this.getac_no()+"\nYour current Balance is "+this.getBalance() );
        this.history.add("Initial Amount of " + inibal+" Deposited ");
//        String query = "append into customer history1 values(Initial Amount of " + inibal+" Deposited )";
//        ResultSet rs= st.executeQuery(query);
    }

    //Random method generate the random account number and verify that number didnt own by existing customer
    double random(){
        int f=0;
        double result=-1;
        while(f==0) {
            Random r = new Random();
            int branchCode = 356000;
            int min = 100;
            int max = 999;
            int rnum = r.nextInt(max - min + 1) + min;
            result = rnum + branchCode;
            for (User t : list) {
                if (t.getac_no() == result) {
                    f=1;
                    break;
                }
            }
            if(f!=1){
                break;
            }
        }

        return result;
    }

    //getac_no() used to get the Account number
    public int getac_no(){
        return (int)Math.round(ac_no);
    }

    //getname() used to get the Account holder name
    public String getname(){
        return name;
    }

    //getbalance() used to get the balance of the Account
    public double getBalance(){
        return balance;
    }

    //getIndex() used to get the index number through that we can get the particular user
    public int getIndex(){
        return index;
    }

    //getpassword() is used to get password for verify the customer while login
    public String getPassword() {
        return password;
    }

    //This deposit method used to deposit the amount to customer account
    public void deposit(double money){
        this.balance +=money;
        history.add("Deposited: " + money);
        System.out.println("The amount of "+money +" is Deposited Successfully");
    }

    //This deposit method used to withdraw the amount to customer account
    public void withdraw(double money){
        this.balance-=money;
        history.add("Withdrawal: " + money);
        System.out.println("The amount of "+money +" is Withdrawal Successfully");

    }

    //This deposit method used to Tranfer the amount from one customer to another account
    public void transfer(User a ,double money){
        this.balance -=money;
        a.balance+=money;
        this.history.add("Transferred : " + money+" to Account number "+a.ac_no);
        System.out.println("The amount of "+money +" is Transfered from "+this.ac_no+" to " +a.ac_no+" Successfully");
    }
//    public List<String> getTransactionHistory() {
//        return history;
//    }

    //This method getTransactionHistory() used to show the transaction detail done by customer
public void getTransactionHistory() {
    for (String state:history) {
        System.out.println(state);
    }
}


}
