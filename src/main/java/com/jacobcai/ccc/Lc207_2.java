package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc207_2 {
    private List<List<Integer>> adj;
    private int[] status;
    
    public boolean canFinish(int numCourses,
                             int[][] prerequisites) {
        status = new int[numCourses];
        adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1])
               .add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                if (dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * @param i 结点下标
     *
     * @return 有环为真
     */
    private boolean dfs(int i) {
        status[i] = 1;
        for (int successor : adj.get(i)) {
            if (status[successor] == 0) {
                if (dfs(successor)) {
                    return true;
                }
            } else if (status[successor] == 1) {
                return true;
            }
        }
        status[i] = 2;
        return false;
    }
    
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Lc207_2 lc207_2 = new Lc207_2();
        boolean res = lc207_2.canFinish(numCourses,
                                        prerequisites);
        System.out.println("res = " + res);
    }
}
