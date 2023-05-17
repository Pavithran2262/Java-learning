package oops.Inheritance;

public class Management {
    public static void main(String[] args) {
        Manager m1 = new Manager("kumar",50000.0,10000);
        m1.raisesalary(10);
        if(m1 instanceof Manager) {
            System.out.println(m1.getsalary());
        }
        System.out.println(m1.getname());
        Employee e1 = new Employee("bala",5000);
        e1.setname("babu");
        e1.setsalary(50000);
        e1.raisesalary(13);
        System.out.println(e1.getname());
        System.out.println(e1.getsalary());
    }
}
class Employee {
    private String name;
    private double salary;
    Employee(){
        name = "";
        salary = 0.0;
    }
    Employee(String n, double s){

        name = n;
        salary = s;
    }
    public String getname(){
        return name;
    }
    public void setname(String n){
        name=n;
    }
    public double getsalary(){
        return salary;
    }
    public void setsalary(double s){
        salary = s;
    }

    public void raisesalary(int p){
        salary +=((salary/100)*p) ;
    }
}
class Manager extends Employee{
    private double bonus ;
    Manager(String n, double s, double b){
        super(n,s);
        bonus = b;

    }
    public void setbonus(double b){
        bonus = b;
    }
    @Override
    public double getsalary(){
        return super.getsalary() +bonus;
    }

}