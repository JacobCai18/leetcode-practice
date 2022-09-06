package com.jacobcai.ci;

import com.jacobcai.TreeNode;

public class Lc129_2 {
    public int sumNumbers(TreeNode root) {
        // 左边所有数字之和 + 右边所有数字之和
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root,
                    int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
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
        Lc129_2 lc129_2 = new Lc129_2();
        int res = lc129_2.sumNumbers(n4);
        System.out.println("res = " + res);
    }
}
