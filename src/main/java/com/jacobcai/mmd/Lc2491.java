package com.jacobcai.mmd;

import java.util.Arrays;

public class Lc2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int sum = skill[0] + skill[n - 1];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (skill[i] + skill[n - i - 1] != sum) return -1;
            ans += (long) skill[i] * skill[n - i - 1];
        }
        return ans / 2;
    }

    public static void main(String[] args) {
        Lc2491 lc2491 = new Lc2491();
        int[] skill = {3, 2, 5, 1, 3, 4};
        long res = lc2491.dividePlayers(skill);
        System.out.println("res = " + res);
    }
}
