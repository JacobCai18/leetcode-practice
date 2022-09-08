package com.jacobcai.cc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc155 {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    
    public Lc155() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.pop()
                 .equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    public static void main(String[] args) {
        Lc155 minStack = new Lc155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int param_1 = minStack.getMin();
        minStack.pop();
        int param_2 = minStack.top();
        int param_3 = minStack.getMin();
        System.out.println("param_1 = " + param_1);
        System.out.println("param_2 = " + param_2);
        System.out.println("param_3 = " + param_3);
    }
}
