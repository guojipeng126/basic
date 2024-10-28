package com.company;


/**
 * 将给出的链表中的节点每 K 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 K 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 O(1)
 * 例如：
 * 给定的链表是1→2→3→4→5
 * 对于  k=2, 你应该返回 2→1→4→3→5
 * 对于  k=3, 你应该返回 3→2→1→4→5
 **/
public class Solution_链表中节点翻转K个一组 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode tmp = reverseKGroup(node, 2);

        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }


    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        //构造一个新的头节点，方便返回值时找到反转后链表的头节点。
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, tmp = null;
        int len = 0;

        while (head != null) {
            ++len;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}

//class ListNode {
//    ListNode next;
//    int val;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
