package com.jacobcai.dc;

public class Lc556 {
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n)
                             .toCharArray();
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = len - 1;
        while (j >= i && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums,
             i,
             j);
        reverse(nums,
                i + 1,
                len - 1);
        long res = Long.parseLong(new String(nums));
        return res > Integer.MAX_VALUE ?
               -1 :
               (int) res;
    }
    
    private void reverse(char[] nums,
                         int i,
                         int j) {
        while (i < j) {
            swap(nums,
                 i++,
                 j--);
        }
    }
    
    private void swap(char[] nums,
                      int i,
                      int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int n = 123432;
        Lc556 lc556 = new Lc556();
        int res = lc556.nextGreaterElement(n);
        System.out.println("res = " + res);
    }
}
