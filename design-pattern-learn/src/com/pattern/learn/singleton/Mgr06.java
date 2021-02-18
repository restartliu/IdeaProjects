package com.pattern.learn.singleton;

// perfect perfect
public enum Mgr06 {
    INSTANCE;

    private TestEnumObject testEnumObject;

    Mgr06(){
        testEnumObject = new TestEnumObject();
    }

    public TestEnumObject getInstance(){
        return this.testEnumObject;
    }
}
