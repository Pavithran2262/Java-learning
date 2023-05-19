package Bank;

import java.lang.reflect.Array;
import java.util.*;
public class User extends Main{
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
    public User(String accountHolderName , String passwordd , double inibal) {
        this.ac_no = random();
        this.name = accountHolderName;
        this.password = passwordd;
        this.balance = inibal;
        this.index = count;
        this.history = new ArrayList<>();
        count ++;
        System.out.println("Hi "+this.getname()+" your Account number is "+this.getac_no()+"\nYour current Balance is "+this.getBalance() );
        this.history.add("Initial Amount of " + inibal+" Deposited ");
    }
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
    public int getac_no(){
        return (int)Math.round(ac_no);
    }
    public String getname(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public int getIndex(){
        return index;
    }
    public String getPassword() {
        return password;
    }

    public void deposit(double money){
        this.balance +=money;
        history.add("Deposited: " + money);
        System.out.println("The amount of "+money +" is Deposited Successfully");
    }
    public void withdraw(double money){
        this.balance-=money;
        history.add("Withdrawal: " + money);
        System.out.println("The amount of "+money +" is Withdrawal Successfully");

    }
    public void transfer(User a ,double money){
        this.balance -=money;
        a.balance+=money;
        this.history.add("Transferred : " + money+" to Account number "+a.ac_no);
        System.out.println("The amount of "+money +" is Transfered from "+this.ac_no+" to " +a.ac_no+" Successfully");
    }
//    public List<String> getTransactionHistory() {
//        return history;
//    }
public void getTransactionHistory() {
    for (String state:history) {
        System.out.println(state);
    }
}


}
