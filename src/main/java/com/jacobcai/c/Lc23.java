package com.jacobcai.c;

import com.jacobcai.ListNode;

import java.util.ArrayList;

public class Lc23 {
    ListNode[] lists;
    
    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        return merge(0,
                     lists.length - 1);
    }
    
    public ListNode merge(int le,
                          int ri) {
        if (le == ri) {
            return lists[le];
        }
        if (le > ri) {
            return null;
        }
        int mid = (le + ri) >>> 1;
        return mergeTwoLists(merge(le,
                                   mid),
                             merge(mid + 1,
                                   ri));
    }
    
    public ListNode mergeTwoLists(ListNode list1,
                                  ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ?
                   list2 :
                   list1;
        }
        ListNode pre, dummy;
        pre = dummy = new ListNode();
        while (list1 != null && list2 != null) {
            // 根据两条链表头的值分类
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        // 其中一条链表走到头，pre.next接另一条链表
        pre.next = list1 == null ?
                   list2 :
                   list1;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5, n6, n7, n8;
        ListNode[] lists;
        n3 = new ListNode(5);
        n2 = new ListNode(4,
                          n3);
        n1 = new ListNode(1,
                          n2);
        n6 = new ListNode(4);
        n5 = new ListNode(3,
                          n6);
        n4 = new ListNode(1,
                          n5);
        n8 = new ListNode(6);
        n7 = new ListNode(2,
                          n8);
        lists = new ListNode[]{n1, n4, n7};
        Lc23 lc23 = new Lc23();
        ListNode r = lc23.mergeKLists(lists);
        ArrayList<Integer> res = new ArrayList<>();
        while (r != null) {
            res.add(r.val);
            r = r.next;
        }
        System.out.println("res = " + res);
    }
}
