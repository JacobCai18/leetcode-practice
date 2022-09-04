package com.jacobcai.c;

import com.jacobcai.TreeNode;

public class Lc98 {
    private long pre = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        // 二叉搜索树中序遍历得到升序
        // 二叉搜索树不允许有重复值
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6,
                                      node3,
                                      node7);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode root = new TreeNode(5,
                                     node4,
                                     node6);
        Lc98 lc98 = new Lc98();
        boolean res = lc98.isValidBST(root);
        System.out.println("res = " + res);
    }
}
