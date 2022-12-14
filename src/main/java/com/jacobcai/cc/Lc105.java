package com.jacobcai.cc;

import com.jacobcai.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Lc105 {
    private int[] preorder;
    /**
     * k: root.val, v: index in inorder[]
     */
    private Map<Integer, Integer> inMap;
    
    public TreeNode buildTree(int[] preorder,
                              int[] inorder) {
        this.preorder = preorder;
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
    
    private TreeNode buildTree(int preLe,
                               int preRi,
                               int inLe) {
        if (preLe > preRi) {
            return null;
        }
        int rootVal = preorder[preLe];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = inMap.get(rootVal);
        root.left = buildTree(preLe + 1,
                              inRoot - inLe + preLe,
                              inLe);
        root.right = buildTree(inRoot - inLe + preLe + 1,
                               preRi,
                               inRoot + 1);
        return root;
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Lc105 lc105 = new Lc105();
        TreeNode res = lc105.buildTree(preorder,
                                       inorder);
        TreeNode.print(res);
    }
}
