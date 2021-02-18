package com.pattern.learn.strategy;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter<T> {

    public void sortObject(T[] source, Comparator<T> comparator) {
        if (source.length != 0) {
            if (!(source[0] instanceof Comparable) && comparator == null) {
                System.out.println("Object not implement Comparable interface!");
                return;
            }
        } else {
            System.out.println("Array is null");
            return;
        }

        for (int i = 0; i < source.length - 1; i++) {
            for (int j = source.length - 1; j > i; j--) {
                if (this.trueCompare(source[j], source[j - 1], comparator) > 0) {
                    this.swap(source, j, j - 1);
                }
            }
        }
    }

    public void sortObject(T[] source) {
        this.sortObject(source, null);
    }

    int trueCompare(T o1, T o2, Comparator<T> comparator) {
        if (comparator == null) {
            return ((Comparable<T>) o1).compareTo(o2);
        }
        return comparator.compare(o1, o2);
    }

    private void swap(Object[] array, int i, int j) {
        Object temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public static void main(String[] args) {
        Sorter<Cat> catSorter = new Sorter<>();
        Cat[] cats = {new Cat(10, 50), new Cat(80, 40), new Cat(30, 90), new Cat(40, 30)};
        catSorter.sortObject(cats, (Cat cat1, Cat cat2)->{
            return Integer.compare(cat1.getWeight(), cat2.getWeight());
        });
        System.out.println(Arrays.toString(cats));
    }

}
