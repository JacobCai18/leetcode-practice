package com.jacobcai.mdcc;

import com.jacobcai.ListNode;

public class Lc1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy, pre, n2 = list2;
        dummy = pre = new ListNode(-1, list1);
        while (n2.next != null) n2 = n2.next;
        for (int i = 0; i < a; i++) pre = pre.next;
        ListNode tmp = pre.next;
        pre.next = list2;
        pre = tmp;
        for (int i = a; i < b; i++) pre = pre.next;
        n2.next = pre.next;
        pre.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Lc1669 lc1669 = new Lc1669();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        ListNode n0 = new ListNode(0,n1);
        ListNode n12 = new ListNode(12);
        ListNode n11 = new ListNode(11,n12);
        ListNode n10 = new ListNode(10,n11);
        ListNode res = lc1669.mergeInBetween(n0, 3, 4, n10);
        ListNode.print(res);
    }
}
