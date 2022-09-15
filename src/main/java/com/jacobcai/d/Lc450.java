package com.jacobcai.d;

import com.jacobcai.TreeNode;
import com.jacobcai.c.Lc94;

import java.util.List;

public class Lc450 {
    public TreeNode deleteNode(TreeNode root,
                               int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            return root.left;
        } else if (key < root.val) {
            root.left = deleteNode(root.left,
                                   key);
        } else {
            root.right = deleteNode(root.right,
                                    key);
        }
        return root;
    }
    
    public static void main(String[] args) {
        int key = 2;
        TreeNode n1, n2, n3, n4, n7;
        n1 = new TreeNode(1);
        n3 = new TreeNode(3);
        n2 = new TreeNode(2,
                          n1,
                          n3);
        n7 = new TreeNode(7);
        n4 = new TreeNode(4,
                          n2,
                          n7);
        Lc450 lc450 = new Lc450();
        Lc94 lc94 = new Lc94();
        TreeNode r = lc450.deleteNode(n4,
                                      key);
        List<Integer> res = lc94.inorderTraversal(r);
        System.out.println("res = " + res);
    }
}
