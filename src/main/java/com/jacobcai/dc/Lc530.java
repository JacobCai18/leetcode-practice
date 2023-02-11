package com.jacobcai.dc;

import com.jacobcai.TreeNode;

public class Lc530 {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != -1) ans = Math.min(ans, root.val - pre);
        pre = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        Lc530 lc530 = new Lc530();
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);
        int res = lc530.getMinimumDifference(n1);
        System.out.println("res = " + res);
    }
}
