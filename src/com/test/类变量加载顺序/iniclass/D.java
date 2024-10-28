package com.test.类变量加载顺序.iniclass;

public class D {

    static{
        System.out.println("D static method");
    }

    {
        System.out.println("D general method");
    }

    public D(){
        System.out.println("D constructor method");
    }
}
