package com.jacobcai.dc;

import java.util.ArrayList;
import java.util.List;

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

public class Lc589 {
    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (var x : root.children) dfs(x, res);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}
