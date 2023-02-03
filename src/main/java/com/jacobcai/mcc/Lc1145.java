package com.jacobcai.mcc;

import com.jacobcai.TreeNode;

public class Lc1145 {
    private int x, xlc, xrc;

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int lc = dfs(node.left);
        int rc = dfs(node.right);
        if (node.val == x) { // 在 x 结点记录此时 x 左右子树各自结点个数
            xlc = lc;
            xrc = rc;
        }
        return lc + rc + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(xlc, xrc), n - 1 - xlc - xrc) * 2 > n;
    }

    public static void main(String[] args) {
        Lc1145 lc1145 = new Lc1145();
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);
        boolean res = lc1145.btreeGameWinningMove(n1, 3, 1);
        System.out.println("res = " + res);
    }
}
