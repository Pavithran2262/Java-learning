package Collections_framework;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();

        list1.add(1);
        list1.add(2);
        list1.add("surya");
        list1.add(true);
        list1.add(2.0);
        list1.add(99999999);
        list1.add(3,"tttttt");
        list1.remove(0);
        int l = list1.size();
        System.out.println(l);

        ArrayList l2 = new ArrayList<>();
        l2.addAll(list1);
        System.out.println(l2);
        for (Object f :list1) {
            System.out.println(f);
        }
        ArrayList l3 = new ArrayList<>();
        l3.addAll(list1);
        l3.addAll(2,list1);
        System.out.println("\n"+ l3);
    }
}
