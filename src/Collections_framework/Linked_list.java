package Collections_framework;

import java.util.LinkedList;
import java.util.Objects;

public class Linked_list {
    public static void main(String[] args) {
        System.out.println("hello");
        LinkedList l1 = new LinkedList();
        l1.add(2);
        l1.add("hi");
        l1.add(9);
        l1.add(true);
        l1.add(23);
        l1.add("hhh");
        System.out.println(l1.size());
        System.out.println(l1.peek());
        System.out.println(l1.pollFirst());
        System.out.println(l1.pollLast());
        System.out.println(l1.poll());
        System.out.println(l1.poll());



        System.out.println(l1);


    }
}
