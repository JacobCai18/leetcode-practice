package com.jacobcai.cc;

import com.jacobcai.Node2;

public class Lc117 {
    public Node2 connect(Node2 root) {
        if (root == null) return null;
        Node2 cur = root;
        Node2 dummy = new Node2(-1);
        while (cur != null) {
            Node2 pre = dummy;
            while (cur != null) {
                if (cur.left != null)
                    pre = pre.next = cur.left;
                if (cur.right != null)
                    pre = pre.next = cur.right;
                cur = cur.next;
            }
            cur = dummy.next;
            dummy.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        Lc117 lc117 = new Lc117();
        Node2 n6 = new Node2(6);
        Node2 n5 = new Node2(5);
        Node2 n4 = new Node2(4);
        Node2 n3 = new Node2(3, null, n6, null);
        Node2 n2 = new Node2(2, n4, n5, null);
        Node2 n1 = new Node2(1, n2, n3, null);
        Node2 res = lc117.connect(n1);
    }
}
