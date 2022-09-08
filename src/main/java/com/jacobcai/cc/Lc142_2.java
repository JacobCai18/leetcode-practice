package com.jacobcai.cc;

import com.jacobcai.ListNode;

public class Lc142_2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // a+n(b+c)+b = 2(a+b) -> a+nb+nc+b = 2a+2b -> a = c+(n-1)(b+c)
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
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
        Lc142_2 lc142_2 = new Lc142_2();
        ListNode res = lc142_2.detectCycle(n1);
        System.out.println("res = " + res.val);
    }
}
