package com.queue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBQTest {

    private static final Comparator<Integer> comparator = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            return 01 > 02 ? -1 : 1;
        }
    };

    private static final BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue(2, comparator);

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + ", 开始生产");
            try {
                Thread.sleep(300);
                priorityBlockingQueue.put(0);
                System.out.println(Thread.currentThread().getName() + ", 生产完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product0").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + ", 开始生产");
            try {
                Thread.sleep(200);
                priorityBlockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + ", 生产完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product1").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + ", 开始生产");
            try {
                Thread.sleep(100);
                priorityBlockingQueue.put(2);
                System.out.println(Thread.currentThread().getName() + ", 生产完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product2").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "，开始获取结果");
                Integer result = priorityBlockingQueue.take();
                System.out.println(Thread.currentThread().getName() + ", 获取到结果：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer0").start();

        new Thread(()->{
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "，开始获取结果");
                Integer result = priorityBlockingQueue.take();
                System.out.println(Thread.currentThread().getName() + ", 获取到结果：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer1").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "，开始获取结果");
                Integer result = priorityBlockingQueue.take();
                System.out.println(Thread.currentThread().getName() + ", 获取到结果：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer2").start();
    }

}
