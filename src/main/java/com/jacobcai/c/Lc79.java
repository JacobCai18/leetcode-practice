package com.jacobcai.c;

public class Lc79 {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '*'; // 先沉岛后复原，可不用 visited
        for (int k = 0; k < 4; k++) // 四个方向 dfs
            if (dfs(board, word, i + dx[k], j + dy[k], idx + 1))
                return true;
        board[i][j] = tmp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i, j, 0))
                    return true;
        return false;
    }

    public static void main(String[] args) {
        Lc79 lc79 = new Lc79();
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        boolean res = lc79.exist(board, word);
        System.out.println("res = " + res);
    }
}
