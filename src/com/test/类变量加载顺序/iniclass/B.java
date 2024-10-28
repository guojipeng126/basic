package com.test.类变量加载顺序.iniclass;

public class B extends A{

    public static C var0 = new C();


    static{
        System.out.println("B static method");
    }

    {
        System.out.println("B general method");
    }

    public D var1 = new D();

    public B(){
        System.out.println("B constructor method");
    }
}
