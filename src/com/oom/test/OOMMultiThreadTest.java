package com.oom.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OOMMultiThreadTest {

    List<User> userList = new ArrayList<>();
    List<Person> personList = new ArrayList<>();

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while(i < 1000000){
                i++;
                User user = new User();
                user.name = "编号" + Math.random()*1000000;
                user.age = ((Integer)(new Random().nextInt(200))).longValue();
                user.high = Math.random()*280;
                userList.add(user);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while(i < 1000000){
                i++;
                Person person = new Person();
                person.name = "编号" + Math.random()*1000000;
                person.age = ((Integer)(new Random().nextInt(200))).doubleValue();
                personList.add(person);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    public static void main(String[] args) {
        new OOMMultiThreadTest().thread1.start();
        new OOMMultiThreadTest().thread2.start();
    }
}

class User{
    String name;
    Long age;
    Double high;
}

class Person{
    String name;
    Double age;
}
