package com.jacobcai.cd;

import com.jacobcai.ListNode;

public class Lc328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd, even, evenHead;
        odd = head;
        even = evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
        Lc328 lc328 = new Lc328();
        ListNode res = lc328.oddEvenList(n1);
        ListNode.print(res);
    }
}
