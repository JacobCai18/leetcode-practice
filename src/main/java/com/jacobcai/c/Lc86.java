package com.jacobcai.c;

import com.jacobcai.ListNode;

public class Lc86 {
    public ListNode partition(ListNode head,
                              int x) {
        ListNode dummyFirst, first, dummySecond, second;
        dummyFirst = first = new ListNode(0);
        dummySecond = second = new ListNode(0);
        while (head != null) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        second.next = null;
        first.next = dummySecond.next;
        return dummyFirst.next;
    }
    
    public static void main(String[] args) {
        ListNode n6 = new ListNode(2);
        ListNode n5 = new ListNode(5,
                                   n6);
        ListNode n4 = new ListNode(2,
                                   n5);
        ListNode n3 = new ListNode(3,
                                   n4);
        ListNode n2 = new ListNode(4,
                                   n3);
        ListNode n1 = new ListNode(1,
                                   n2);
        Lc86 lc86 = new Lc86();
        ListNode res = lc86.partition(n1,
                                      3);
        ListNode.print(res);
    }
}
