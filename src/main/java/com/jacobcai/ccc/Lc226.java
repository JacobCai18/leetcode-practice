package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

public class Lc226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc226 lc226 = new Lc226();
        TreeNode res = lc226.invertTree(n1);
        TreeNode.print(res);
    }
}
