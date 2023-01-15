package com.jacobcai.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc406_3 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]); // 简化比较器
        int n = people.length;
        List<int[]> queue = new ArrayList<>(n);
        for (int[] person : people)
            queue.add(person[1], person);
        return queue.toArray(new int[n][]);
    }

    public static void main(String[] args) {
        Lc406_3 lc406_2 = new Lc406_3();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = lc406_2.reconstructQueue(people);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
