package com.jacobcai.c;

public class Lc79 {
    char[][] board;
    String word;
    boolean[][] visited;
    boolean res;
    
    public boolean exist(char[][] board,
                         String word) {
        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(i,
                        j,
                        0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void dfs(int i,
                     int j,
                     int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            res = true;
            return;
        }
        visited[i][j] = true;
        // 四个方向 dfs
        dfs(i,
            j + 1,
            index + 1);
        dfs(i + 1,
            j,
            index + 1);
        dfs(i,
            j - 1,
            index + 1);
        dfs(i - 1,
            j,
            index + 1);
        visited[i][j] = false;
    }
    
    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        Lc79 lc79 = new Lc79();
        boolean res = lc79.exist(board,
                                 word);
        System.out.println("res = " + res);
    }
}
