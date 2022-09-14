package com.jacobcai.c;

import com.jacobcai.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Lc61 {
    public ListNode rotateRight(ListNode head,
                                int k) {
        if (head == null) {
            return null;
        }
        ListNode dum, le, ri;
        int len = 0;
        dum = le = ri = new ListNode(0,
                                     head);
        // ri走到链表尾节点，并记录链表长度
        while (ri.next != null) {
            ri = ri.next;
            len++;
        }
        k %= len;
        // le走到新尾节点
        int pos = len - k;
        while (pos > 0) {
            le = le.next;
            pos--;
        }
        // 旋转
        ri.next = dum.next;
        dum.next = le.next;
        le.next = null;
        return dum.next;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5;
        n5 = new ListNode(5);
        n4 = new ListNode(4,
                          n5);
        n3 = new ListNode(3,
                          n4);
        n2 = new ListNode(2,
                          n3);
        n1 = new ListNode(1,
                          n2);
        int k = 7;
        Lc61 lc61 = new Lc61();
        ListNode r = lc61.rotateRight(n1,
                                      k);
        List<Integer> res = new ArrayList<>();
        while (r != null) {
            res.add(r.val);
            r = r.next;
        }
        System.out.println("res = " + res);
    }
}
