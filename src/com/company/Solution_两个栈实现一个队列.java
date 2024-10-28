//package com.company;
//
//import java.util.Stack;
//
///**
// * @Description
// * @Author guojipeng
// * @Version 1.0
// **/
//public class Solution_两个栈实现一个队列 {
//
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    public void push(int node) {
//        stack1.push(node);
//        if(stack2.empty()){
//            while(!stack1.empty()){
//                stack2.push(stack1.pop());
//            }
//        }
//    }
//
//    public int pop() {
//        if(stack1.empty() && stack2.empty()){
//            return 0;
//        }else if(stack2.empty()){
//            while(!stack1.empty()){
//                stack2.push(stack1.pop());
//            }
//        }
//        return stack2.pop();
//    }
//}
