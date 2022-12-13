package com.jacobcai.cc;

import com.jacobcai.ListNode;

public class Lc160_2 {
    public ListNode getIntersectionNode(ListNode headA,
                                        ListNode headB) {
        ListNode pA, pB;
        pA = headA;
        pB = headB;
        while (pA != pB) {
            pA = pA == null ?
                 headB :
                 pA.next;
            pB = pB == null ?
                 headA :
                 pB.next;
        }
        return pA;
    }
    
    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5,
                                   n6);
        ListNode n4 = new ListNode(4,
                                   n5);
        ListNode n3 = new ListNode(3,
                                   n4);
        ListNode n2 = new ListNode(2,
                                   n5);
        ListNode n1 = new ListNode(1,
                                   n2);
        Lc160_2 lc160_2 = new Lc160_2();
        ListNode res = lc160_2.getIntersectionNode(n1,
                                                   n3);
        ListNode.print(res);
    }
}
