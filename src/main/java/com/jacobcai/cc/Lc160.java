package com.jacobcai.cc;

import com.jacobcai.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Lc160 {
    public ListNode getIntersectionNode(ListNode headA,
                                        ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        // 不改变原链表结构
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
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
        Lc160 lc160 = new Lc160();
        ListNode res = lc160.getIntersectionNode(n1,
                                                 n3);
        ListNode.print(res);
    }
}
