package com.jacobcai.dc;

import com.jacobcai.TreeNode;

public class Lc513 {
    private int val, maxDepth;
    
    public int findBottomLeftValue(TreeNode root) {
        val = 0;
        maxDepth = 0;
        dfs(root,
            1);
        return val;
    }
    
    private void dfs(TreeNode root,
                     int depth) {
        if (root == null) {
            return;
        }
        int curDepth = depth + 1;
        if (curDepth > maxDepth) {
            maxDepth = curDepth;
            val = root.val;
        }
        dfs(root.left,
            curDepth);
        dfs(root.right,
            curDepth);
    }
    
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3,
                                   n4,
                                   n5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc513 lc513 = new Lc513();
        int res = lc513.findBottomLeftValue(n1);
        System.out.println("res = " + res);
    }
}
