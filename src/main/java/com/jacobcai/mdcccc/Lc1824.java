package com.jacobcai.mdcccc;

public class Lc1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int a = 1, b = 0, c = 1;
        for (int i = 1; i < n; i++) {
            int o = obstacles[i];
            if (o == 1) a = 0x3f3f3f3f;
            if (o == 2) b = 0x3f3f3f3f;
            if (o == 3) c = 0x3f3f3f3f;
            if (o != 1) a = Math.min(a, Math.min(b, c) + 1);
            if (o != 2) b = Math.min(b, Math.min(c, a) + 1);
            if (o != 3) c = Math.min(c, Math.min(a, b) + 1);
        }
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Lc1824 lc1824 = new Lc1824();
        int[] obstacles = {0, 1, 2, 3, 0};
        int res = lc1824.minSideJumps(obstacles);
        System.out.println("res = " + res);
    }
}
