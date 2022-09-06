package com.jacobcai.ci;

import com.jacobcai.TreeNode;

public class Lc129 {
    int res, cur;
    
    public int sumNumbers(TreeNode root) {
        res = cur = 0;
        // 将在叶节点的数字计入总和
        backtrack(root);
        return res;
    }
    
    private void backtrack(TreeNode root) {
        if (root == null) {
            return;
        }
        cur = cur * 10 + root.val;
        backtrack(root.left);
        backtrack(root.right);
        if (root.left == null && root.right == null) {
            res += cur;
        }
        cur = cur / 10;
    }
    
    public static void main(String[] args) {
        TreeNode n4, n9, n0, n5, n1;
        n5 = new TreeNode(5);
        n1 = new TreeNode(1);
        n9 = new TreeNode(9,
                          n5,
                          n1);
        n0 = new TreeNode(0);
        n4 = new TreeNode(4,
                          n9,
                          n0);
        Lc129 lc129 = new Lc129();
        int res = lc129.sumNumbers(n4);
        System.out.println("res = " + res);
    }
}
