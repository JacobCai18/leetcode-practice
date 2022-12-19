package com.jacobcai.ccc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Lc207 {
    public boolean canFinish(int numCourses,
                             int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
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
            index++;
            for (int successor : adj.get(curr)) {
                if (--inDegree[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }
        return index == numCourses;
    }
    
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Lc207 lc207 = new Lc207();
        boolean res = lc207.canFinish(numCourses,
                                      prerequisites);
        System.out.println("res = " + res);
    }
}
