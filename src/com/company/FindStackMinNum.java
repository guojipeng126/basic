package com.company;

import java.util.Stack;

/**
 * 定义栈的数据结构，在该类型中实现一个查找最小值的min函数；
 * 要求min、push、pop函数的时间复杂度都是1
 */
public class FindStackMinNum {

    public static void main(String ... a) {
        MinStack ms = new MinStack();
        ms.push(5);
        System.out.println(ms.min());
        ms.push(6);
        ms.push(2);
        ms.push(1);
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());

    }

    static class MinStack {

        //两个栈里的元素数量是一样的
        private Stack<Integer> minStack = new Stack<Integer>();
        private Stack<Integer> stack = new Stack<Integer>();

        public int pop() {
            minStack.pop();
            return stack.pop();
        }

        public void push(int num) {
            if (minStack.size() <= 0) {
                minStack.push(num);
            }
            Integer min = minStack.lastElement();
            if (num < min) {
                minStack.push(num);
            } else {
                minStack.push(min);
            }
            stack.push(num);
        }

        public int min() {
            if (minStack.size() <= 0) {
                return -1;
            }
            return minStack.lastElement();
        }
    }
}




