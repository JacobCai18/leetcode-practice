package com.jacobcai.d;

import com.jacobcai.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Lc437_2 {
    /**
     * <根结点到当前结点的前缀和, 路径数量>
     */
    private Map<Long, Integer> prefix;
    private int targetSum;
    
    public int pathSum(TreeNode root,
                       int targetSum) {
        prefix = new HashMap<>();
        this.targetSum = targetSum;
        // 前缀和为 0 的路径数量为 1
        prefix.put(0L,
                   1);
        return dfs(root,
                   0);
    }
    
    public int dfs(TreeNode root,
                   long curr) {
        if (root == null) {
            return 0;
        }
        // 根结点到当前结点前缀和
        curr += root.val;
        int res;
        // 到当前结点区间和为 targetSum 的路径数量
        res = prefix.getOrDefault(curr - targetSum,
                                  0);
        // 根结点到当前结点前缀和为 curr 的路径数量 + 1
        prefix.put(curr,
                   prefix.getOrDefault(curr,
                                       0) + 1);
        res += dfs(root.left,
                   curr);
        res += dfs(root.right,
                   curr);
        // 返回前为了不影响上面的结点，根结点到当前结点前缀和为 curr 的数量 - 1
        prefix.put(curr,
                   prefix.getOrDefault(curr,
                                       0) - 1);
        return res;
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
        Lc437_2 lc437_2 = new Lc437_2();
        int res = lc437_2.pathSum(n9,
                                  8);
        System.out.println("res = " + res);
    }
}
