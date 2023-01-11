package com.jacobcai.cc;

public class Lc135 {
    public int candy(int[] ratings) {
        // inc = 递增长度, dec = 递减长度, pre = 最近递增长度, cnt = 糖果数目
        int inc = 1, dec = 0, pre = 1, cnt = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                dec = 0;
                pre = inc = ratings[i - 1] == ratings[i] ? 1 : inc + 1;
                cnt += inc;
            } else {
                inc = 1;
                dec++;
                if (dec == pre) dec++;
                cnt += dec;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] ratings = {1,6,10,8,7,3,2};
        Lc135 lc135 = new Lc135();
        int res = lc135.candy(ratings);
        System.out.println("res = " + res);
    }
}
