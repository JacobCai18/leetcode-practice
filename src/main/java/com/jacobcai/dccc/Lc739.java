package com.jacobcai.dccc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.getFirst()]) {
                int j = stack.removeFirst();
                res[j] = i - j;
            }
            stack.addFirst(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Lc739 lc739 = new Lc739();
        int[] res = lc739.dailyTemperatures(temperatures);
        System.out.println("res = " + Arrays.toString(res));
    }
}
