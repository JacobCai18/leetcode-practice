package com.jacobcai.dccc;

import com.jacobcai.TreeNode;
import com.jacobcai.c.Lc94;

import java.util.List;

public class Lc701_2 {
    public TreeNode insertIntoBST(TreeNode root,
                                  int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        int val = 5;
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
        Lc701_2 lc701_2 = new Lc701_2();
        Lc94 lc94 = new Lc94();
        TreeNode r = lc701_2.insertIntoBST(n4,
                                           val);
        List<Integer> res = lc94.inorderTraversal(r);
        System.out.println("res = " + res);
    }
}
