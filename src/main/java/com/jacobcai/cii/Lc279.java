package com.jacobcai.cii;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc279 {
    public int numSquares(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        int count = 1;
        // 从0到n一共有n + 1个
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int num = queue.poll();
                for (int j = 1; j * j <= num; j++) {
                    if (j * j == num) {
                        return count;
                    }
                    int next = num - j * j;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            count++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int n = 12;
        Lc279 lc279 = new Lc279();
        int res = lc279.numSquares(n);
        System.out.println("res = " + res);
    }
}
