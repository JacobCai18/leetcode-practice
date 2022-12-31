package com.jacobcai.dcccc;

import com.jacobcai.ListNode;

public class Lc876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3,
                                   n4);
        ListNode n2 = new ListNode(2,
                                   n3);
        ListNode n1 = new ListNode(1,
                                   n2);
        Lc876 lc876 = new Lc876();
        ListNode res = lc876.middleNode(n1);
        ListNode.print(res);
    }
}
