package com.test.类变量加载顺序.iniclass;

public class C {

    static{
        System.out.println("C static method");
    }

    {
        System.out.println("C general method");
    }

    public C(){
        System.out.println("C constructor method");
    }
}
