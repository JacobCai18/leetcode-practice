package com.jacobcai.cc;

import com.jacobcai.ListNode;

public class Lc143 {
    public void reorderList(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev, curr;
        prev = null;
        curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode tmp1, tmp2, h1, h2;
        h1 = head;
        h2 = prev;
        while (h1 != null && h2 != null) {
            tmp1 = h1.next;
            tmp2 = h2.next;
            h1.next = h2;
            h1 = tmp1;
            h2.next = h1;
            h2 = tmp2;
        }
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
        Lc143 lc143 = new Lc143();
        lc143.reorderList(n1);
        ListNode.print(n1);
    }
}
