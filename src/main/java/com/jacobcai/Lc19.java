package com.jacobcai;

import java.util.ArrayList;
import java.util.List;

public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head,
                                     int n) {
        ListNode dummy = new ListNode(0,
                                      head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Delete nth ListNode
        slow.next = slow.next.next;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,
                                      node5);
        ListNode node3 = new ListNode(3,
                                      node4);
        ListNode node2 = new ListNode(2,
                                      node3);
        ListNode head = new ListNode(1,
                                     node2);
        Lc19 lc19 = new Lc19();
        ListNode resHead = lc19.removeNthFromEnd(head,
                                                 2);
        List<Integer> res = new ArrayList<>();
        while (resHead != null) {
            res.add(resHead.val);
            resHead = resHead.next;
        }
        System.out.println("res = " + res);
    }
}
