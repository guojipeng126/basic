package com;

/**
 * jdk7之后版本的intern（）：
 *
 * 一、在调用后发现StringTable中没有所对应的字符串。
 * String s1 = new String("hello") + new String("world");
 * 这句代码会在堆中new一个String对象（其实并没有这么简单，后面讲）
 * s1.intern();
 * s1调用了intern方法，然后发现在StringTable中并没有所对应的字符串，
 * 那么jvm就会在StringTable中放入一个地址，这个地址指向s1所new的String对象。
 * String s2 = "helloworld";
 * jvm发现在StringTable中已经存在指向"helloworld"的地址了，就会把StringTable中的
 * 地址给s2。此时s1和s2都指向这个地址。所以是同一个对象。于是返回了true
 *
 *
 * 二、在调用后发现StringTable中存在所对应的字符串。
 * String s1 = new String("hello") + new String("world");
 * 这句代码会在堆中new一个String对象（其实并没有这么简单，后面讲）
 * String s2 = "helloworld";
 * jvm在StringTable中存储这一个"helloworld"。
 * 此时s1和s2是两个不同的对象。s1指向堆中，s2指向StringTable。
 * s1.intern();
 * jvm发现在StringTable中已经存在"helloworld"了，那么什么都不会做，仅仅是
 * 返回这一个字符串。所以结果为false
 *
 *
 *
 * 1、jvm先new了一个StringBuilder（非多线程安全），
 * 2、然后new了一个String，
 * 3、调用了StringBuilder的append方法，添加了这一个String对象。
 * 4、再次new一个String对象
 * 5、再次调用了StringBuilder的append方法，添加了这一个String对象。
 * 6、调用StringBuilder的toString方法，将StringBuilder转为String
 */
public class StringTest {

    public static void main(String[] args) {
//        String s0 = new StringBuilder("abc").toString();
//        System.out.println(s0 == s0.intern());

//        String s1 = new StringBuilder("ab").append("c").toString();
//        System.out.println(s1 == s1.intern());

        String s2 = new StringBuilder("计算").append("技术").toString();
        System.out.println(s2);
        System.out.println(s2.intern());
        System.out.println(s2 == s2.intern());

//        String s3 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s3 == s3.intern());

//        String s4 = new String("计算机技术");
//        System.out.println(s4 == s4.intern());
    }
}
