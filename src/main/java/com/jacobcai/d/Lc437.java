package com.jacobcai.d;

import com.jacobcai.TreeNode;

public class Lc437 {
    public int pathSum(TreeNode root,
                       int targetSum) {
        if (root == null) {
            return 0;
        }
        int cnt = rootSum(root,
                          targetSum);
        cnt += pathSum(root.left,
                       targetSum);
        cnt += pathSum(root.right,
                       targetSum);
        return cnt;
    }
    
    public int rootSum(TreeNode root,
                       long targetSum) {
        if (root == null) {
            return 0;
        }
        int cnt, val;
        cnt = 0;
        val = root.val;
        if (val == targetSum) {
            cnt++;
        }
        cnt += rootSum(root.left,
                       targetSum - val);
        cnt += rootSum(root.right,
                       targetSum - val);
        return cnt;
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3,
                                   n1,
                                   n2);
        TreeNode n5 = new TreeNode(2,
                                   null,
                                   n3);
        
        TreeNode n6 = new TreeNode(5,
                                   n4,
                                   n5);
        TreeNode n7 = new TreeNode(11);
        TreeNode n8 = new TreeNode(-3,
                                   null,
                                   n7);
        TreeNode n9 = new TreeNode(10,
                                   n6,
                                   n8);
        Lc437 lc437 = new Lc437();
        int res = lc437.pathSum(n9,
                                8);
        System.out.println("res = " + res);
    }
}
