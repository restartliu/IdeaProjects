package com.test.base.enumeration;

public class EnumTest {
    public enum MyColor{red, blue, green};

    public static void main(String[] args) {
        MyColor color = MyColor.red;
        switch (color){
            case red:
                System.out.println(MyColor.red);
                break;
            case blue:
                System.out.println(MyColor.blue);
                break;
            case green:
                System.out.println(MyColor.green);
                break;
            default:
                System.out.println("default");
        }
        System.out.println(color);
    }
}
