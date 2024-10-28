package com.threadLocalTest;

import javax.sound.sampled.FloatControl;
import java.lang.ref.SoftReference;
import java.util.IdentityHashMap;

public class Test {

    static class nest01{
        String name;
    }



    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = Thread.currentThread();
        local.set("local");
        System.out.println(local.get());

        new Thread(()->{
            Thread thread01 = Thread.currentThread();
            thread01.setName("thread01");
            local.set("thread01");
            System.out.println(local.get());
        }).start();

        new Thread(()->{
            Thread thread02 = Thread.currentThread();
            thread02.setName("thread02");
            local.set("thread02");
            System.out.println(local.get());
        }).start();

        Thread.sleep(1000);

        System.out.println(local.get());

    }
}
