package com.jacobcai.c;

import com.jacobcai.ListNode;

public class Lc92 {
    public ListNode reverseBetween(ListNode head,
                                   int left,
                                   int right) {
        ListNode dummy, prev, curr, next;
        dummy = prev = new ListNode(-1,
                                    head);
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4,
                                   n5);
        ListNode n3 = new ListNode(3,
                                   n4);
        ListNode n2 = new ListNode(2,
                                   n3);
        ListNode n1 = new ListNode(1,
                                   n2);
        Lc92 lc92 = new Lc92();
        ListNode res = lc92.reverseBetween(n1,
                                           2,
                                           4);
        ListNode.print(res);
    }
}
