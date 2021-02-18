package com.pattern.learn;


import com.pattern.learn.singleton.*;

import java.util.LinkedList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        /*
        first way
        Mgr01 mgr01 = Mgr01.getInstance();
        mgr01.testPrint();
        */

        /*
        second way, third way, fourth way, fifth way
        for (int i = 0; i < 100; i++){
            // lambda expression for interface only have one method as parameter
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
        */

        /*sixth way*/
        TestEnumObject instance = Mgr06.INSTANCE.getInstance();
        instance.testPrint();
    }

}
