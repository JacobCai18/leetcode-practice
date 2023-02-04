package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc212 {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    private static class TrieNode {
        TrieNode[] next;
        String word;
        int cnt;

        TrieNode() {
            next = new TrieNode[27];
            word = "";
            cnt = 0;
        }
    }

    private void insert(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.next[idx] == null)
                node.next[idx] = new TrieNode();
            node = node.next[idx];
            node.cnt++;
        }
        node.word = word;
    }

    private void del(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            TrieNode next = node.next[idx];
            if (--next.cnt == 0) {
                node.next[idx] = null;
                break;
            }
            node = next;
        }
    }

    private void dfs(char[][] board, List<String> res, TrieNode root, int i, int j, TrieNode node) {
        if (node == null) return;
        if (!node.word.isEmpty()) {
            String word = node.word;
            node.word = "";
            res.add(word);
            del(root, word);
        }
        char cur = board[i][j];
        board[i][j] = 'z' + 1;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k], nj = j + dy[k];
            if (ni > -1 && ni < board.length && nj > -1 && nj < board[0].length)
                dfs(board, res, root, ni, nj, node.next[board[ni][nj] - 'a']);
        }
        board[i][j] = cur;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (var word : words) insert(root, word);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, res, root, i, j, root.next[board[i][j] - 'a']);
        return res;
    }

    public static void main(String[] args) {
        Lc212 lc212 = new Lc212();
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = lc212.findWords(board, words);
        System.out.println("res = " + res);
    }
}
