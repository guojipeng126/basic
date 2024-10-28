package com.multithreading;

public class TryFinallyTest {

    public static void main(String[] args) {

        System.out.println(test());
    }

    // 返回值出现前，finally块会先执行，如果finally块有return，会覆盖先前的return
    public static int test(){
        int kk = 0;
        try{
            kk = 1;
            System.out.println("try");
            return kk;
        }catch(Exception e){
            kk = 2;
            System.out.println("catch");
            return kk;
        }finally{
            kk = 3;
            System.out.println("finally");
            return kk;
        }
    }
}
