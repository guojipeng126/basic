package com.company;


import java.util.Stack;

public class Solution_翻转链表 {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;        //让next引用指向head下一个节点，
            head.next = pre;        //pre始终指向当前head的前一个节点，这样可以反转节点了。
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.lastElement());
        System.out.println(stack.lastElement());
        System.out.println(stack.firstElement());
    }
}
