package com.jacobcai.d;

import com.jacobcai.TreeNode;
import com.jacobcai.c.Lc94;

import java.util.List;

public class Lc450_2 {
    public TreeNode deleteNode(TreeNode root,
                               int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                TreeNode predecessor = root.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                root.val = predecessor.val;
                root.left = deleteNode(root.left,
                                       predecessor.val);
            } else {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.val = successor.val;
                root.right = deleteNode(root.right,
                                        successor.val);
            }
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
        Lc450_2 lc450_2 = new Lc450_2();
        Lc94 lc94 = new Lc94();
        TreeNode r = lc450_2.deleteNode(n4,
                                        key);
        List<Integer> res = lc94.inorderTraversal(r);
        System.out.println("res = " + res);
    }
}
