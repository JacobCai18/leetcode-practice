package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc173_2 {
    private TreeNode cur;
    private Deque<TreeNode> stk;

    public Lc173_2(TreeNode root) {
        cur = root;
        stk = new ArrayDeque<>();
    }

    public int next() {
        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }
        cur = stk.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return cur != null || !stk.isEmpty();
    }
}
