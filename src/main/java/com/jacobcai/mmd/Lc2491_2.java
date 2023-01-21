package com.jacobcai.mmd;

public class Lc2491_2 {
    public long dividePlayers(int[] skill) {
        int[] map = new int[1001]; // <skillNum, cnt>
        long ans = 0, sum = 0;
        int target, n = skill.length;
        for (int num : skill) {
            sum += num;
            map[num]++;
        }
        if (sum % (n / 2) != 0) return -1;
        target = (int) (sum / (n / 2));
        for (int i = 0; i < 1001; i++) {
            if (map[i] == 0) continue;
            if (map[i] != map[target - i]) return -1;
            ans += (long) map[i] * i * (target - i);
        }
        return ans / 2;
    }

    public static void main(String[] args) {
        Lc2491_2 lc2491 = new Lc2491_2();
        int[] skill = {3, 2, 5, 1, 3, 4};
        long res = lc2491.dividePlayers(skill);
        System.out.println("res = " + res);
    }
}
