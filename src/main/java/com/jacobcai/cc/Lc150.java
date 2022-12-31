package com.jacobcai.cc;

public class Lc150 {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int index = -1;
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack[--index] += stack[index + 1];
                case "-" -> stack[--index] -= stack[index + 1];
                case "*" -> stack[--index] *= stack[index + 1];
                case "/" -> stack[--index] /= stack[index + 1];
                default -> stack[++index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
    
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Lc150 lc150 = new Lc150();
        int res = lc150.evalRPN(tokens);
        System.out.println("res = " + res);
    }
}
