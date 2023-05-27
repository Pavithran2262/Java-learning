package Interface_practice;

class cycle {
    void display(){
    System.out.println("This is cycle ");
    }
}
public class Anonymous_classes {
    public static void main(String[] args) {
        System.out.println("Anonymous Class ...");
        cycle c=new cycle()
        {
            void display(){
                System.out.println("This is bike");
            }
        };

        c.display();
        cycle c2 = new cycle();
        c2.display();
    }
}
