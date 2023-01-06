package com.jacobcai.dc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lc513_2 {
    public int findBottomLeftValue(TreeNode root) {
        int val = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                val = node.val;
            }
        }
        return val;
    }
    
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3,
                                   n4,
                                   n5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc513_2 lc513_2 = new Lc513_2();
        int res = lc513_2.findBottomLeftValue(n1);
        System.out.println("res = " + res);
    }
}
