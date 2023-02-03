package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc173 {
    private int idx;
    private List<Integer> arr;

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

    public Lc173(TreeNode root) {
        idx = 0;
        arr = new ArrayList<>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }
}
