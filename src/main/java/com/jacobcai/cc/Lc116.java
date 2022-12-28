package com.jacobcai.cc;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lc116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (i < size - 1) {
                    n.next = q.peek();
                }
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
        }
        return root;
    }
    
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {
        }
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val,
                    Node _left,
                    Node _right,
                    Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3,
                           n1,
                           n2,
                           null);
        Lc116 lc116 = new Lc116();
        Node res = lc116.connect(n3);
    }
}
