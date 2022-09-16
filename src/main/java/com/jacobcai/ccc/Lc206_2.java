package com.jacobcai.ccc;

import com.jacobcai.ListNode;

public class Lc206_2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5;
        n5 = new ListNode(5);
        n4 = new ListNode(4,
                          n5);
        n3 = new ListNode(3,
                          n4);
        n2 = new ListNode(2,
                          n3);
        n1 = new ListNode(1,
                          n2);
        Lc206_2 lc206_2 = new Lc206_2();
        ListNode res = lc206_2.reverseList(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
