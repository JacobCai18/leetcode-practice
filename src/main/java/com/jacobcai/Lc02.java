package com.jacobcai;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc02 {
    public ListNode addTwoNumbers(ListNode l1,
                                  ListNode l2) {
        ListNode dummy, tail;
        int carry = 0;
        dummy = tail = new ListNode();
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ?
                     0 :
                     l1.val;
            int n2 = l2 == null ?
                     0 :
                     l2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            tail = tail.next = new ListNode(sum % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(4,
                                      node3);
        ListNode l1 = new ListNode(2,
                                   node2);
        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(6,
                                   n3);
        ListNode l2 = new ListNode(5,
                                   n2);
        Lc02 lc02 = new Lc02();
        ListNode head = lc02.addTwoNumbers(l1,
                                           l2);
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addFirst(head.val);
            head = head.next;
        }
        System.out.println("deque = " + deque);
    }
}
