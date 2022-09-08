package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc114_2 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode predecessor = cur.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3;
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1,
                          n2,
                          n3);
        Lc114_2 lc114_2 = new Lc114_2();
        lc114_2.flatten(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.right;
        }
    }
}
