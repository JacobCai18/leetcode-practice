package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.*;

public class Lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0,
                    cur);
        }
        return res;
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
        Lc107 lc107 = new Lc107();
        List<List<Integer>> res = lc107.levelOrderBottom(n3);
        System.out.println("res = " + res);
    }
}
