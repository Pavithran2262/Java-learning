package oops.abstraction;

abstract class bike {
    void run(){
        System.out.println("Bike Running");
    }
     abstract void running();
}
class pulsar extends bike{
    @Override
    void running() {
        System.out.println("Pulsar running");
    }
}
class honda extends bike{
    @Override
    void running(){
        System.out.println("Honda running");
    }
        }