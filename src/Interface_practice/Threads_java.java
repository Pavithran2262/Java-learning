
package Interface_practice;

class A extends Thread {
    public void run() {
        for (int i = 0; i <= 8; i++) {
            synchronized (Threads_java.class) {
                System.out.println("hi");
                Threads_java.class.notify();  // Notify the other thread
                try {
                    Threads_java.class.wait();  // Wait for the other thread to notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i <= 8; i++) {
            synchronized (Threads_java.class) {
                System.out.println("hello");
                Threads_java.class.notify();  // Notify the other thread
                try {
                    Threads_java.class.wait();  // Wait for the other thread to notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Threads_java {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Threads!...");
        A obj1 = new A();
        B obj2 = new B();

        obj1.start();
        obj2.start();

//        synchronized (Threads_java.class) {
//            Threads_java.class.wait();  // Wait for the first thread to start
//        }

        System.out.println("Done");
    }
}


//package Interface_practice;
//
//import static java.lang.Thread.sleep;
//
//class A extends Thread{
//    public void run(){
//        for (int i =0;i<=100;i++){
//            System.out.println("hi");
////            try {
////                wait();
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
//        }
//        try {
//            sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
////        try {
////            wait();
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//    }
//}
//
//class B extends Thread{
//    public void run(){
//        for (int i =0;i<=100;i++){
//            System.out.println("second thread");
//            notify();
//        }
//
//        try {
//            sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//}
//public class Threads_java {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Threads!...");
//        A obj1 = new A();
//        B obj2 = new B();
//
//        obj1.start();
////        obj1.wait(100);
//
//        obj2.start();
//        obj2.join();
//        obj1.join();
//
////        obj2.wait(100);
//
//
//        System.out.println("hi..............................");
//    }
//}
