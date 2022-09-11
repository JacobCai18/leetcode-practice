package com.jacobcai.c;

import com.jacobcai.ListNode;

import java.util.ArrayList;

public class Lc25 {
    public ListNode reverseKGroup(ListNode head,
                                  int k) {
        ListNode prev, tail, dummy;
        prev = tail = dummy = new ListNode(0,
                                           head);
        while (tail.next != null) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            ListNode curr = prev.next;
            ListNode next = tail.next;
            tail.next = null;
            prev.next = reverseList(curr);
            curr.next = next;
            prev = tail = curr;
        }
        return dummy.next;
    }
    
    private ListNode reverseList(ListNode head) {
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
        ListNode n1, n2, n3, n4, n5, r;
        int k = 2;
        ArrayList<Integer> res = new ArrayList<>();
        n5 = new ListNode(5);
        n4 = new ListNode(4,
                          n5);
        n3 = new ListNode(3,
                          n4);
        n2 = new ListNode(2,
                          n3);
        n1 = new ListNode(1,
                          n2);
        Lc25 lc25 = new Lc25();
        r = lc25.reverseKGroup(n1,
                               k);
        while (r != null) {
            res.add(r.val);
            r = r.next;
        }
        System.out.println("res = " + res);
    }
}
