package com.company;


import java.util.Stack;

/**
 * 给定两个整数序列，第一个是压栈序列；
 * 判断第二个是否是出站序列，
 * 假设入栈的所有数字均不相等，如1、2、3、4、5是压栈序列，4、5、3、2、1是对应的一个出站序列；4、3、5、1、2肯定不是出站序列；
 */
public class Solution_出站序列 {
    public static void main(String ... args) {
        int[] num = {1, 2, 3, 4, 5};
//        int[] num2={2,1,5,3,4};
        int[] num2={4,5,3,2,1};
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for (int i = 0; i < num2.length; i++) {
            s2.push(num2[i]);
        }

        System.out.println(testOrder(num, s1, s2));
    }

    public static boolean testOrder(int[] num, Stack<Integer> s1, Stack<Integer> s2) {
        int length = num.length;
        for (int i = 0; i < length; i++) {
            s1.push(num[i]);
            int s2Num = s2.lastElement();
            if (s2Num == s1.lastElement().intValue()) {
                s1.pop();
                s2.pop();
            }
        }
        while (!s1.isEmpty()) {
            if (!s1.pop().equals(s2.pop())) {
                return false;
            }
        }
        return true;
    }
}
