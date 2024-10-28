package com.multithreading;

import java.util.concurrent.CompletableFuture;

public class FutureTest {

    //CompletableFuture
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture cf1 = CompletableFuture.supplyAsync(()->{     //异步线程执行
            System.out.println("yi bu zhi xing_0");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("yi bu zhi xing_1");
            return "Hell";
        }).thenAccept(x->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
        });
        CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{     //异步线程执行
            System.out.println("yi bu zhi xing");
            return "Hell_22";
        }).thenAccept(x->{
            System.out.println(x);
        });

        System.out.println("end——0");
        CompletableFuture.allOf(cf1, cf2).join();       //等待所有异步线程执行结束
        System.out.println("end——1");
    }
}