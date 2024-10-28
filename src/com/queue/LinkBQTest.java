package com.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkBQTest {

    private static final BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue(3);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + ", 开始获取结果");
                Integer result = linkedBlockingQueue.take();
                System.out.println(Thread.currentThread().getName() + ", 获取到结果：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer0").start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + ", 开始获取结果");
                Integer result = linkedBlockingQueue.take();
                System.out.println(Thread.currentThread().getName() + ", 获取到结果：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer1").start();


        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "，开始生产数据");
                linkedBlockingQueue.put(0);
                System.out.println(Thread.currentThread().getName() + "，已经生产了数据");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product0").start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + ", 开始生产数据");
                linkedBlockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + ", 已经生产了数据");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product1").start();

    }

}
