package oops.polymorphism;

    public class Animal {
        public void makeSound() {
            System.out.println("Animal sound ....");
        }
    }

    class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow!....");
        }
    }

    class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woow!....");
        }
    }


