package com.jacobcai.dcc;

import com.jacobcai.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc654_2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] le = new int[len];
        int[] ri = new int[len];
        Arrays.fill(le,
                    -1);
        Arrays.fill(ri,
                    -1);
        TreeNode[] tree = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ri[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                le[i] = stack.peek();
            }
            stack.push(i);
        }
        TreeNode root = null;
        for (int i = 0; i < len; ++i) {
            if (le[i] == -1 && ri[i] == -1) {
                root = tree[i];
            } else if (ri[i] == -1 || (le[i] != -1 && nums[le[i]] < nums[ri[i]])) {
                tree[le[i]].right = tree[i];
            } else {
                tree[ri[i]].left = tree[i];
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Lc654_2 lc654_2 = new Lc654_2();
        TreeNode res = lc654_2.constructMaximumBinaryTree(nums);
        TreeNode.print(res);
    }
}
