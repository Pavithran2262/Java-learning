package oops.Inheritance;

import oops.Inheritance.Car;

public class Main {
    public static void main(String[] args) {
        System.out.println("program started");
        Car myCar = new Car();
//        Scanner sc = new Scanner(System.in);
//        string brand = sc.nextLine();
        myCar.brand = "Audi";
        myCar.year = 2023;
        myCar.setmax_speed(400);

        System.out.println("Brand: " + myCar.brand);
        System.out.println("Year: " + myCar.year);
        System.out.println("Maximum speed is" + myCar.getmax_speed());

        myCar.start();
        myCar.stop();
    }
}