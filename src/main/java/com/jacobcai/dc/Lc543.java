package com.jacobcai.dc;

import com.jacobcai.TreeNode;

public class Lc543 {
    /**
     * 直径长度：任意两个结点路径长度中的最大值
     */
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        depth(root);
        return res;
    }
    
    /**
     * 在返回该结点深度前将左右子树高度加和成直径长度
     *
     * @param root 结点
     *
     * @return 该结点的深度
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leDepth = depth(root.left);
        int riDepth = depth(root.right);
        res = Math.max(res,
                       leDepth + riDepth);
        return Math.max(leDepth,
                        riDepth) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2,
                                   n4,
                                   n5);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc543 lc543 = new Lc543();
        int res = lc543.diameterOfBinaryTree(n1);
        System.out.println("res = " + res);
    }
}
