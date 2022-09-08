package com.jacobcai.ccc;

import com.jacobcai.ListNode;

public class Lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5;
        n5 = new ListNode(5);
        n4 = new ListNode(4,
                          n5);
        n3 = new ListNode(3,
                          n4);
        n2 = new ListNode(2,
                          n3);
        n1 = new ListNode(1,
                          n2);
        Lc206 lc206 = new Lc206();
        ListNode res = lc206.reverseList(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
