package com.jacobcai.d;

import java.util.Arrays;

public class Lc406_2 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1]; // 由升序变为降序
            }
        });
        int n = people.length;
        int[][] queue = new int[n][]; // 只给行分配空间，不给列分配空间
        for (int[] person : people) {
            int pos = person[1] + 1;
            int p = 0, j = -1;
            while (p != pos) {
                j++;
                if (queue[j] == null) {
                    p++;
                }
            }
            queue[j] = person; // 传递引用，浅复制
        }
        return queue;
    }

    public static void main(String[] args) {
        Lc406_2 lc406_2 = new Lc406_2();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = lc406_2.reconstructQueue(people);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
