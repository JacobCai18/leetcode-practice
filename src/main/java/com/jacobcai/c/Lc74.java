package com.jacobcai.c;

public class Lc74 {
    public boolean searchMatrix(int[][] matrix,
                                int target) {
        int rowLen, colLen;
        int le, ri;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        le = 0;
        ri = rowLen * colLen - 1;
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            int val = matrix[mid / colLen][mid % colLen];
            if (val == target) {
                return true;
            } else if (val < target) {
                le = mid + 1;
            } else {
                ri = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        Lc74 lc74 = new Lc74();
        boolean res = lc74.searchMatrix(matrix,
                                        target);
        System.out.println("res = " + res);
    }
}
