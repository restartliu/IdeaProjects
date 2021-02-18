package com.pattern.learn.singleton;

// lazy loading(lazy man mode)
// disadvantage :
//      this way achieves the purpose of loading in demand, but it brings the problem of thread insecurity
//      when two or more thread access instance method in a same time, it will cause thread insecurity
public class Mgr02 {

    private static Mgr02 INSTANCE;

    private Mgr02(){}

    public static Mgr02 getInstance(){
        if (INSTANCE==null) {
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

}
