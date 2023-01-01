package com.jacobcai.ccc;

import com.jacobcai.ListNode;

public class Lc237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    public static void main(String[] args) {
        ListNode n4 = new ListNode(9);
        ListNode n3 = new ListNode(1,
                                   n4);
        ListNode n2 = new ListNode(5,
                                   n3);
        ListNode n1 = new ListNode(4,
                                   n2);
        Lc237 lc237 = new Lc237();
        lc237.deleteNode(n2);
        ListNode.print(n1);
    }
}
