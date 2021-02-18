package com.pattern.learn.singleton;

// hungry man mode
// disadvantage :
//      this object will be instantiated when it's class be loaded whether use it or not
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    public void testPrint(){
        System.out.println("hello world");
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }
}
