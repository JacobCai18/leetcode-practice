package com.jacobcai.dcc;

import com.jacobcai.TreeNode;

public class Lc617 {
    public TreeNode mergeTrees(TreeNode root1,
                               TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left,
                                 root2.left);
        merged.right = mergeTrees(root1.right,
                                  root2.right);
        return merged;
    }
    
    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3,
                                   null,
                                   n4);
        Lc617 lc617 = new Lc617();
        TreeNode res = lc617.mergeTrees(n1,
                                        n3);
        TreeNode.print(res);
    }
}
