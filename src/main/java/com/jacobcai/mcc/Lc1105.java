package com.jacobcai.mcc;

public class Lc1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1]; // dp[i] = 选择了 i 本书的最小高度
        // 选择 0 本书的最小高度为 0
        for (int ri = 0; ri < n; ri++) {
            int width = books[ri][0], height = books[ri][1];
            dp[ri + 1] = dp[ri] + height; // 把新的书放入新开的一层
            for (int le = ri - 1; le > -1; le--) { // 不断把上一层的书尝试放入最后一层
                width += books[le][0];
                if (width > shelfWidth) break; // 若把上一层最后一本书放入最后一层后最后一层书的厚度之和大于书架宽度，则跳出
                height = Math.max(height, books[le][1]);
                dp[ri + 1] = Math.min(dp[ri + 1], dp[le] + height); // 错开一位
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lc1105 lc1105 = new Lc1105();
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int res = lc1105.minHeightShelves(books, 4);
        System.out.println("res = " + res);
    }
}
