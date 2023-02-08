package com.jacobcai.mccc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc1233 {
    private static class TrieNode {
        Map<String, TrieNode> next;
        int idx;

        TrieNode() {
            next = new HashMap<>();
            idx = -1;
        }
    }

    private void dfs(String[] folder, List<String> res, TrieNode node) {
        if (node.idx > -1) {
            res.add(folder[node.idx]); // 将路径终止结点标志设计为该路径在 folder 中的下标
            return;
        }
        for (var next : node.next.values())
            dfs(folder, res, next);
    }

    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < folder.length; i++) {
            String[] path = folder[i].split("/"); // 按 '/' 分割路径
            TrieNode node = root;
            for (var str : path) {
                if (!node.next.containsKey(str))
                    node.next.put(str, new TrieNode()); // 将储存下一个结点的表设计为哈希表而不是长度为 26 的数组，因为结点是字符串而不是字母
                node = node.next.get(str);
            }
            node.idx = i;
        }
        List<String> res = new ArrayList<>();
        dfs(folder, res, root);
        return res;
    }

    public static void main(String[] args) {
        Lc1233 lc1233 = new Lc1233();
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> res = lc1233.removeSubfolders(folder);
        System.out.println("res = " + res);
    }
}
