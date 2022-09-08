package com.jacobcai.cc;

import com.jacobcai.ListNode;

public class Lc141 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇时有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2, n3, n4;
        n4 = new ListNode(4);
        n3 = new ListNode(3,
                          n4);
        n2 = new ListNode(2,
                          n3);
        n1 = new ListNode(1,
                          n2);
        n4.next = n2;
        Lc141 lc141 = new Lc141();
        boolean res = lc141.hasCycle(n1);
        System.out.println("res = " + res);
    }
}
