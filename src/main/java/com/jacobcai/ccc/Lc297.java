package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

public class Lc297 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); // 构建 str 用 sb
        rserialize(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        return rdeserialize(dataArray, new int[]{0}); // 用数组保存状态
    }

    private void rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        rserialize(root.left, sb);
        rserialize(root.right, sb);
    }

    private TreeNode rdeserialize(String[] dataArr, int[] idx) {
        if (dataArr[idx[0]].equals("null")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[idx[0]++]));
        root.left = rdeserialize(dataArr, idx);
        root.right = rdeserialize(dataArr, idx);
        return root;
    }

    public static void main(String[] args) {
        Lc297 codec = new Lc297();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, n2, n5);
        String serializedStr = codec.serialize(n1);
        TreeNode deserializedTreeNode = codec.deserialize(serializedStr);
    }
}
