package com.jacobcai.ccc;

public class Lc211 {
    private static class TrieNode {
        TrieNode[] next;
        boolean isEnd;

        TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }
    }

    private final TrieNode root;

    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isEnd;
        if (word.charAt(i) == '.') {
            for (var next : node.next)
                if (next != null && dfs(word, i + 1, next))
                    return true;
            return false;
        } else {
            TrieNode next = node.next[word.charAt(i) - 'a'];
            return next != null && dfs(word, i + 1, next);
        }
    }

    public Lc211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.next[idx] == null)
                node.next[idx] = new TrieNode();
            node = node.next[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}
