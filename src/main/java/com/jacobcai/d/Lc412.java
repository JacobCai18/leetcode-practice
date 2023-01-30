package com.jacobcai.d;

import java.util.ArrayList;
import java.util.List;

public class Lc412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Lc412 lc412 = new Lc412();
        List<String> res = lc412.fizzBuzz(5);
        System.out.println("res = " + res);
    }
}
