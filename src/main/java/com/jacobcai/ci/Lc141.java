package com.jacobcai.ci;

import com.jacobcai.ListNode;

public class Lc141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        while (fast != null && fast.next != null) {
            // 快慢指针相遇时有环
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
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
