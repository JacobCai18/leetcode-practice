package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc113 {
    List<List<Integer>> res;
    Deque<Integer> stack;
    
    public List<List<Integer>> pathSum(TreeNode root,
                                       int targetSum) {
        res = new ArrayList<>();
        stack = new ArrayDeque<>();
        backtrack(root,
                  targetSum);
        return res;
    }
    
    private void backtrack(TreeNode root,
                           int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        stack.addLast(root.val);
        backtrack(root.left,
                  targetSum);
        backtrack(root.right,
                  targetSum);
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(stack));
        }
        stack.removeLast();
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3;
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1,
                          n2,
                          n3);
        int targetSum = 4;
        Lc113 lc113 = new Lc113();
        List<List<Integer>> res = lc113.pathSum(n1,
                                                targetSum);
        System.out.println("res = " + res);
    }
}
