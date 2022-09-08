package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc111_2 {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        TreeNode n3, n9, n20, n15, n7;
        n15 = new TreeNode(15);
        n7 = new TreeNode(7);
        n20 = new TreeNode(20,
                           n15,
                           n7);
        n9 = new TreeNode(9);
        n3 = new TreeNode(3,
                          n9,
                          n20);
        Lc111_2 lc111_2 = new Lc111_2();
        int res = lc111_2.minDepth(n3);
        System.out.println("res = " + res);
    }
}
