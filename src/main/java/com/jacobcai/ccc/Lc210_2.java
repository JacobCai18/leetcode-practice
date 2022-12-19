package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc210_2 {
    private int[] res;
    /**
     * 0-未访问，1-访问中，2-已访问
     */
    private int[] status;
    /**
     * 有向图中是否存在环
     */
    private boolean hasCircle;
    /**
     * 模拟栈，从后往前放到 res 中
     */
    private int index;
    /**
     * 邻接表
     */
    private List<List<Integer>> adj;
    
    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {
        res = new int[numCourses];
        status = new int[numCourses];
        adj = new ArrayList<>(numCourses);
        hasCircle = false;
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1])
               .add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                dfs(i);
                if (hasCircle) {
                    return new int[0];
                }
            }
        }
        return res;
    }
    
    private void dfs(int i) {
        status[i] = 1;
        for (int successor : adj.get(i)) {
            if (status[successor] == 0) {
                dfs(successor);
                if (hasCircle) {
                    return;
                }
            } else if (status[successor] == 1) {
                hasCircle = true;
                return;
            }
        }
        status[i] = 2;
        res[index--] = i;
    }
    
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        Lc210_2 lc210_2 = new Lc210_2();
        int[] res = lc210_2.findOrder(numCourses,
                                      prerequisites);
        System.out.println("res = " + Arrays.toString(res));
    }
}
