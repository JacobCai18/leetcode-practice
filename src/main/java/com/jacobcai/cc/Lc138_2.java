package com.jacobcai.cc;

import com.jacobcai.Node;

public class Lc138_2 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node next = cur.next;
            if (next != null) cur.next = next.next;
            cur = next;
        }
        return res;
    }
}
