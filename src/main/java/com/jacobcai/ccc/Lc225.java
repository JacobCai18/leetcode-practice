package com.jacobcai.ccc;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lc225 {
    Queue<Integer> queue;
    
    public Lc225() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
        Lc225 lc225 = new Lc225();
        lc225.push(1);
        lc225.push(2);
        System.out.println(lc225.top());
        System.out.println(lc225.pop());
        System.out.println(lc225.empty());
    }
}
