package com.test.base.container;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        Collection list = new LinkedList();
        for (int i = 0; i < 20; i++){
            list.add(i);
        }
        Collections.shuffle((List) list);
        for (Object o : list) {
            System.out.print(o + "\t");
        }
        System.out.println();
        Collections.sort((List) list);
        for (Object o : list) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println(Collections.binarySearch((List<? extends Comparable<? super Object>>) list, 5));
    }
}
