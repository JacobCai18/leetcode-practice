package com.jacobcai.mcc;

public class Lc1138 {
    public String alphabetBoardPath(String target) {
        int cx = 0, cy = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            if (nx < cx) res.append("U".repeat(cx - nx));
            if (ny < cy) res.append("L".repeat(cy - ny));
            if (nx > cx) res.append("D".repeat(nx - cx));
            if (ny > cy) res.append("R".repeat(ny - cy));
            res.append('!');
            cx = nx;
            cy = ny;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Lc1138 lc1138 = new Lc1138();
        String target = "leetcode";
        String res = lc1138.alphabetBoardPath(target);
        System.out.println("res = " + res);
    }
}
