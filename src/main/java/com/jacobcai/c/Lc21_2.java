package com.jacobcai.c;

import com.jacobcai.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Lc21_2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    
    public static void main(String[] args) {
        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(2, n3);
        ListNode l1 = new ListNode(1, n2);
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(3, node3);
        ListNode l2 = new ListNode(1, node2);
        Lc21_2 lc21_2 = new Lc21_2();
        ListNode resHead = lc21_2.mergeTwoLists(l1, l2);
        List<Integer> res = new ArrayList<>();
        while (resHead != null) {
            res.add(resHead.val);
            resHead = resHead.next;
        }
        System.out.println("res = " + res);
    }
}
