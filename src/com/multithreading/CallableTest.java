package com.multithreading;

import java.util.concurrent.Callable;

public class CallableTest {

    public static void main(String[] args) {
        int[] testArr_0 = new int[]{1, 3, 4, 6};
        int[] testArr_1 = {1, 3, 4, 6};

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hello");
                return "";
            }
        };
    }
}
