package com.jacobcai.c;

import com.jacobcai.ListNode;

public class Lc83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy;
        dummy = new ListNode(0,
                             head);
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(1,
                                      node3);
        ListNode head = new ListNode(1,
                                     node2);
        Lc83 lc83 = new Lc83();
        ListNode res = lc83.deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
