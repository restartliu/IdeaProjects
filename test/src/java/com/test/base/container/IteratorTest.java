package com.test.base.container;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        Collection test = new LinkedList();
        LinkedList test_temp = (LinkedList) test;
        test.add("liu");
        test.add("guang");
        test.add("long");
        Iterator iterator = test.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println(test_temp.getFirst());
        }
        System.out.println(iterator.hasNext());

        Integer[] integer = {1,2,3,4,5,6,7,8,9};
        Iterator<Integer> iterator1 = Arrays.stream(integer).iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
