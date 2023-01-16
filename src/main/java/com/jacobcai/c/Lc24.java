package com.jacobcai.c;

import com.jacobcai.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Lc24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Lc24 lc24 = new Lc24();
        ListNode head = lc24.swapPairs(n1);
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println("list = " + list);
    }
}
