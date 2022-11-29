package com.jacobcai;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {
    }
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val,
                    ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public static void print(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        System.out.println("res = " + res);
    }
}
