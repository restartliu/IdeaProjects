package com.pattern.learn.strategy;

import sun.net.util.IPAddressUtil;

public class Cat implements Comparable<Cat>{

    private final int height;
    private final int weight;

    public Cat(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Cat o) {
        return Integer.compare(this.height, o.height);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
