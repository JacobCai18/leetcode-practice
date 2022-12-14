package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Lc106 {
    int[] postorder;
    /**
     * k: rootVal, v: index
     */
    Map<Integer, Integer> inMap;
    
    public TreeNode buildTree(int[] inorder,
                              int[] postorder) {
        this.postorder = postorder;
        int len = inorder.length;
        inMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            inMap.put(inorder[i],
                      i);
        }
        return buildTree(0,
                         len - 1,
                         0);
    }
    
    private TreeNode buildTree(int postLe,
                               int postRi,
                               int inLe) {
        if (postLe > postRi) {
            return null;
        }
        int rootVal = postorder[postRi];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = inMap.get(rootVal);
        root.left = buildTree(postLe,
                              postLe + inRoot - inLe - 1,
                              inLe);
        root.right = buildTree(postLe + inRoot - inLe,
                               postRi - 1,
                               inRoot + 1);
        return root;
    }
    
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Lc106 lc106 = new Lc106();
        TreeNode res = lc106.buildTree(inorder,
                                       postorder);
        TreeNode.print(res);
    }
}
