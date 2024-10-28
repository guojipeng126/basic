package com.test.类变量加载顺序.iniclass;

public class A {

    static{
        System.out.println("A static method");
    }

    {
        System.out.println("A general method");
    }

    public A(){
        System.out.println("A constructor method");
    }
}
