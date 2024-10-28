package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTest2 {

    public <T> T getResult(T[] t){
        System.out.println();
        return t[0];
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> list = new ArrayList<>();
        list.add("00");
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");

        ExecutorService executorService = Executors.newFixedThreadPool(3);      //声明3个线程的固定线程池

        List<Future> resultList = new ArrayList();

        for (String s : list) {
            Future future = executorService.submit(()->{
                System.out.println(s);
                return s;
            });
            resultList.add(future);
        }
        Thread.sleep(1000);
        System.out.println("执行结果，开始获取结果！");

        executorService.shutdown();     //线程池结束

        for (Future future : resultList) {
            System.out.println(future.get().toString());        //获取线程的执行结果
        }

    }
}
