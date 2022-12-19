package com.jacobcai.ccc;

import java.util.*;

public class Lc210 {
    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1])
               .add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[index++] = curr;
            for (int successor : adj.get(curr)) {
                if (--inDegree[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        Lc210 lc210 = new Lc210();
        int[] res = lc210.findOrder(numCourses,
                                    prerequisites);
        System.out.println("res = " + Arrays.toString(res));
    }
}
