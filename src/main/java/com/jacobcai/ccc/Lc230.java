package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc230 {
    public int kthSmallest(TreeNode root,
                           int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
            root = deque.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1,
                                   null,
                                   n2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3,
                                   n1,
                                   n4);
        Lc230 lc230 = new Lc230();
        int res = lc230.kthSmallest(n3,
                                    1);
        System.out.println("res = " + res);
    }
}
