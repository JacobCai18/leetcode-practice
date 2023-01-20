package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

public class Lc297_2 {
    public String serialize(TreeNode root) {
        if (root == null) return "X";
        String left = "(" + serialize(root.left) + ")";
        String right = "(" + serialize(root.right) + ")";
        return left + root.val + right;
    }

    public TreeNode deserialize(String data) {
        return parse(data, new int[]{0});
    }

    private TreeNode parse(String data, int[] idx) {
        if (data.charAt(idx[0]) == 'X') {
            idx[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(0);
        cur.left = parseSubtree(data, idx);
        cur.val = parseInt(data, idx);
        cur.right = parseSubtree(data, idx);
        return cur;
    }

    private TreeNode parseSubtree(String data, int[] idx) {
        idx[0]++; // 跳过左括号
        TreeNode subtree = parse(data, idx);
        idx[0]++; // 跳过右括号
        return subtree;
    }

    private int parseInt(String data, int[] idx) {
        int x = 0, sgn = 1;
        if (!Character.isDigit(data.charAt(idx[0]))) {
            sgn = -1;
            idx[0]++;
        }
        while (Character.isDigit(data.charAt(idx[0])))
            x = x * 10 + data.charAt(idx[0]++) - '0';
        return x * sgn;
    }

    public static void main(String[] args) {
        Lc297_2 codec = new Lc297_2();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, n2, n5);
        String serializedStr = codec.serialize(n1);
        TreeNode deserializedTreeNode = codec.deserialize(serializedStr);
    }
}
