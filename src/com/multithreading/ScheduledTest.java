package com.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {

    static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(5);


    public static void main(String[] args) throws Exception {
        scheduledExecutorService.schedule(()->{
            Thread.currentThread().setName("线程1");
            System.out.println("调度任务1");
        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(()->{
            Thread.currentThread().setName("线程2");
            System.out.println("调度任务2");
        }, 4, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(()->{
            Thread.currentThread().setName("线程3");
            System.out.println("调度任务3");
        }, 3, TimeUnit.SECONDS);

        System.out.println("jieshu");

        scheduledExecutorService.shutdown();    //使用完，需要关闭线程池
    }

}
