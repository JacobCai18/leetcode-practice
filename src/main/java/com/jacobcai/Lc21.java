package com.jacobcai;

import java.util.ArrayList;
import java.util.List;

public class Lc21 {
    public ListNode mergeTwoLists(ListNode list1,
                                  ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (list1 != null && list2 != null) {
            // 根据两条链表头的值分类
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // 其中一条链表走到头，prev.next接另一条链表
        prev.next = list1 == null ?
                    list2 :
                    list1;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(2,
                                   n3);
        ListNode l1 = new ListNode(1,
                                   n2);
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(3,
                                      node3);
        ListNode l2 = new ListNode(1,
                                   node2);
        Lc21 lc21 = new Lc21();
        ListNode resHead = lc21.mergeTwoLists(l1,
                                              l2);
        List<Integer> res = new ArrayList<>();
        while (resHead != null) {
            res.add(resHead.val);
            resHead = resHead.next;
        }
        System.out.println("res = " + res);
    }
}
