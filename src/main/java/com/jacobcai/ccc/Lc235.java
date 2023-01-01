package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

public class Lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {
        TreeNode a = root;
        while (true) {
            if (p.val < a.val && q.val < a.val) {
                a = a.left;
            } else if (p.val > a.val && q.val > a.val) {
                a = a.right;
            } else {
                break;
            }
        }
        return a;
    }
    
    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc235 lc235 = new Lc235();
        TreeNode res = lc235.lowestCommonAncestor(n1,
                                                  n2,
                                                  n3);
        TreeNode.print(res);
    }
}
