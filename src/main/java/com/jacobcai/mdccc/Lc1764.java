package com.jacobcai.mdccc;

public class Lc1764 {
    public boolean canChoose(int[][] groups,
                             int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length && i < groups.length; ) {
            if (canMatch(groups[i],
                         nums,
                         k)) {
                k += groups[i].length;
                i++;
            } else {
                k++;
            }
        }
        return i == groups.length;
    }
    
    private boolean canMatch(int[] groupI,
                             int[] nums,
                             int k) {
        if (k + groupI.length > nums.length) {
            return false;
        }
        for (int j = 0; j < groupI.length; j++) {
            if (groupI[j] != nums[k + j]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] groups = {{1, -1, -1}, {3, -2, 0}};
        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        Lc1764 lc1764 = new Lc1764();
        boolean res = lc1764.canChoose(groups,
                                       nums);
        System.out.println("res = " + res);
    }
}
