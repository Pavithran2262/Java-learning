package oops.polymorphism;

public class Main {
    public static void main (String[] args) {


        Animal animal1 = new Animal();
        Animal animal2 = new Cat();
        Animal animal3 = new Dog();

        animal1.makeSound();
        animal2.makeSound();
        animal3.makeSound();

        method_overloading ob = new method_overloading();

        System.out.println(ob.max(5,6));
        System.out.println(ob.max(50.9,6.0));
        char d='d',e='e';
        System.out.println(ob.max(d,e));
    }
}