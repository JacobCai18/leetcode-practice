package com.jacobcai.d;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Lc429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                cur.add(node.val);
                for (var x : node.children)
                    q.offer(x);
            }
            res.add(cur);
        }
        return res;
    }
}

