package com.jacobcai.cd;

import com.jacobcai.TreeNode;

public class Lc337 {
    public int rob(TreeNode root) {
        // dp[0]: 不拿， dp[1]: 拿
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] le = dfs(node.left);
        int[] ri = dfs(node.right);
        int n = Math.max(le[0], le[1]) + Math.max(ri[0], ri[1]);
        int y = node.val + le[0] + ri[0];
        return new int[]{n, y};
    }
    
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2,
                                   null,
                                   n4);
        TreeNode n3 = new TreeNode(3,
                                   null,
                                   n5);
        TreeNode n1 = new TreeNode(3,
                                   n2,
                                   n3);
        Lc337 lc337 = new Lc337();
        int res = lc337.rob(n1);
        System.out.println("res = " + res);
    }
}
