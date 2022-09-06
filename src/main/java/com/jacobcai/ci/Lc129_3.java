package com.jacobcai.ci;

import com.jacobcai.TreeNode;

public class Lc129_3 {
    int res;
    
    public int sumNumbers(TreeNode root) {
        res = 0;
        // 将在叶节点的数字计入总和
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root,
                     int cur) {
        if (root == null) {
            return;
        }
        cur = cur * 10 + root.val;
        dfs(root.left, cur);
        dfs(root.right, cur);
        if (root.left == null && root.right == null) {
            res += cur;
        }
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
        Lc129_3 lc129_3 = new Lc129_3();
        int res = lc129_3.sumNumbers(n4);
        System.out.println("res = " + res);
    }
}
