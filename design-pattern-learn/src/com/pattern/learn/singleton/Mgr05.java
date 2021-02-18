package com.pattern.learn.singleton;

// perfect way to implement singleton
public class Mgr05 {

    private Mgr05(){
    }

    private static class Mgr05Holder{
        private final static Mgr05 INSTANCE  = new Mgr05();
    }

    public static Mgr05 getInstance(){
        return Mgr05Holder.INSTANCE;
    }
}
