package com.jacobcai.cc;

import com.jacobcai.ListNode;

public class Lc147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= curr.val)
                    prev = prev.next;
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Lc147 lc147 = new Lc147();
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(4, n2);
        ListNode res = lc147.insertionSortList(n1);
        ListNode.print(res);
    }
}
