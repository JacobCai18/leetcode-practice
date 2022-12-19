package com.jacobcai.ccc;

import com.jacobcai.ListNode;

public class Lc203 {
    public ListNode removeElements(ListNode head,
                                   int val) {
        ListNode dummy, prev;
        prev = dummy = new ListNode(-1,
                                    head);
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode n3 = new ListNode(2);
        ListNode n2 = new ListNode(2,
                                   n3);
        ListNode n1 = new ListNode(1,
                                   n2);
        Lc203 lc203 = new Lc203();
        ListNode res = lc203.removeElements(n1,
                                            2);
        ListNode.print(res);
    }
}
