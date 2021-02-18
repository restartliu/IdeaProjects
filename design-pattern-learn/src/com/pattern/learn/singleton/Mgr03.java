package com.pattern.learn.singleton;

// disadvantage :
//      this way will reduce performance
public class Mgr03 {

    private static Mgr03 INSTANCE;

    private Mgr03(){
    }

    public static synchronized Mgr03 getInstance(){
        if (INSTANCE==null) {
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }
}
