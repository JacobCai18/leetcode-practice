package com.jacobcai.c;

import com.jacobcai.TreeNode;

public class Lc99 {
    private TreeNode x, y, pre;
    
    public void recoverTree(TreeNode root) {
        x = y = pre = null;
        // 找到出错的两个节点
        inorder(root);
        swap(x,
             y);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null) {
            if (pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                }
            }
        }
        pre = root;
        inorder(root.right);
    }
    
    private void swap(TreeNode x,
                      TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
    
    public static void main(String[] args) {
        TreeNode node1, node2, node3, node4;
        node2 = new TreeNode(2);
        node4 = new TreeNode(4,
                             node2,
                             null);
        node1 = new TreeNode(1);
        node3 = new TreeNode(3,
                             node1,
                             node4);
        Lc99 lc99 = new Lc99();
        lc99.recoverTree(node3);
    }
}
