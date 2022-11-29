package com.jacobcai.c;

import com.jacobcai.ListNode;

public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 当前结点值与下一个结点值不同，处理下一个结点
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        // 当前结点值与下一个结点值相同，处理下一个与当前结点值不同的结点
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    }
    
    public static void main(String[] args) {
        ListNode n7 = new ListNode(4);
        ListNode n6 = new ListNode(4,
                                   n7);
        ListNode n5 = new ListNode(4,
                                   n6);
        ListNode n4 = new ListNode(3,
                                   n5);
        ListNode n3 = new ListNode(3,
                                   n4);
        ListNode n2 = new ListNode(3,
                                   n3);
        ListNode n1 = new ListNode(1,
                                   n2);
        Lc82 lc82 = new Lc82();
        ListNode res = lc82.deleteDuplicates(n1);
        ListNode.print(res);
    }
}
