package com.jacobcai.dcc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Lc637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(15);
        TreeNode n3 = new TreeNode(20,
                                   n4,
                                   n5);
        TreeNode n2 = new TreeNode(9);
        TreeNode n1 = new TreeNode(3,
                                   n2,
                                   n3);
        Lc637 lc637 = new Lc637();
        List<Double> res = lc637.averageOfLevels(n1);
        System.out.println("res = " + res);
    }
}
