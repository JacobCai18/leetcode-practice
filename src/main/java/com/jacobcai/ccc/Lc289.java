package com.jacobcai.ccc;

public class Lc289 {
    public void gameOfLife(int[][] board) {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx > -1 && nx < m && ny > -1 && ny < n)
                        sum += (board[nx][ny] & 1); // 只累加最低位
                }
                if (board[i][j] == 1) {
                    if (sum == 2 || sum == 3)
                        board[i][j] |= 2;  // 使用第二个bit标记是否存活
                } else if (sum == 3)
                    board[i][j] |= 2;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] >>= 1;
    }
}
