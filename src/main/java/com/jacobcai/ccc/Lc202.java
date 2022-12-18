package com.jacobcai.ccc;

public class Lc202 {
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        while (fast != 1 && getNext(fast) != 1) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (fast == slow) {
                return false;
            }
        }
        return true;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Lc202 lc202 = new Lc202();
        boolean res = lc202.isHappy(19);
        System.out.println("res = " + res);
    }
}
