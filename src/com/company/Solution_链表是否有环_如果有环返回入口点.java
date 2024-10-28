package com.company;

/**
 * 给定一个链表，检查链表中是否有环
 */
public class Solution_链表是否有环_如果有环返回入口点 {

    public ListNode detectCycle(ListNode head) {
        //1.链表为空，或只有一个结点
        if (head == null || head.next == null) {
            return null;
        }

        //2.通过快慢指针查找相遇点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //3.根据相遇点，找出环开始的位置
            if (fast == slow) {
                ListNode temp = head;//从第一个位置开始遍历
                while (temp != slow) {//到相遇点时停止,即环开始的结点
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }

        }//while
        return null;
    }
}

class ListNode {
    ListNode next;
    int  val;
    public ListNode(int val){
        val = val;
    }
}
