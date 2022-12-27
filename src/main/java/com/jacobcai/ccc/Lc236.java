package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

public class Lc236 {
    private TreeNode res;
    
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {
        res = null;
        dfs(root,
            p,
            q);
        return res;
    }
    
    /**
     * @return p 或 q 是否在 root 这棵树上
     */
    private boolean dfs(TreeNode root,
                        TreeNode p,
                        TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left,
                           p,
                           q);
        boolean rson = dfs(root.right,
                           p,
                           q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            res = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2,
                                   n1,
                                   n3);
        Lc236 lc236 = new Lc236();
        TreeNode res = lc236.lowestCommonAncestor(n2,
                                                  n1,
                                                  n3);
        TreeNode.print(res);
    }
}
