package com.jacobcai.cc;

import com.jacobcai.ListNode;

public class Lc148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0,
                                      head);
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge(head1,
                                  head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummy.next;
    }
    
    public ListNode merge(ListNode head1,
                          ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1,
                                   n4);
        ListNode n2 = new ListNode(2,
                                   n3);
        ListNode n1 = new ListNode(4,
                                   n2);
        Lc148 lc148 = new Lc148();
        ListNode res = lc148.sortList(n1);
        ListNode.print(res);
    }
}
