package com.edureka.mstestsactuator.service;

public class Calculator {
    private final MyClass myClass;
    private final YourClass yourClass;

    public Calculator(MyClass myClass, YourClass yourClass) {
        this.myClass = myClass;
        this.yourClass = yourClass;
    }


    public int add(int a, int b) {
        final int c = myClass.process(a);
        final int d = yourClass.process(b);

        return c + d;
    }
}
