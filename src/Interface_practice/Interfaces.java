package Interface_practice;


interface Ridable{
    void ride();
    default void display(){
        System.out.println("display here...");
    }
}
class car implements Ridable{

    @Override
    public void ride() {
        System.out.println("car riding");
    }
    public void display(){
        System.out.println("car display here...");
    }
}

class bike implements Ridable{

    @Override
    public void ride() {
        System.out.println("bike riding");
    }
    public void display(){
        System.out.println("bike display here...");
    }
}
class mechanic {
    public void check(Ridable c){
        System.out.println("checking....");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        Ridable r = new car();
        mechanic m = new mechanic();
        car c = new car();
        bike b = new bike();
        m.check(c);
        m.check(b);
        r.display();
        c.display();
        b.display();
        c.ride();
        b.ride();

    }
}
