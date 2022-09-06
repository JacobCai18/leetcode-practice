package com.jacobcai.ci;

import com.jacobcai.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Lc142 {
    public ListNode detectCycle(ListNode head) {
        // 出现重复元素时该节点就是入环的第一个节点
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2, n3, n4;
        n4 = new ListNode(4);
        n3 = new ListNode(3,
                          n4);
        n2 = new ListNode(2,
                          n3);
        n1 = new ListNode(1,
                          n2);
        n4.next = n2;
        Lc142 lc142 = new Lc142();
        ListNode res = lc142.detectCycle(n1);
        System.out.println("res = " + res.val);
    }
}
