package com.jacobcai.d;

import com.jacobcai.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stk1 = new ArrayDeque<>();
        Deque<Integer> stk2 = new ArrayDeque<>();
        while (l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode curNode = null;
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            int curVal = carry;
            if (!stk1.isEmpty()) {
                curVal += stk1.pop();
            }
            if (!stk2.isEmpty()) {
                curVal += stk2.pop();
            }
            carry = curVal / 10;
            curVal %= 10;
            curNode = new ListNode(curVal, curNode);
        }
        if (carry == 1) {
            curNode = new ListNode(1, curNode);
        }
        return curNode;
    }

    public static void main(String[] args) {
        Lc445 lc445 = new Lc445();
        ListNode n3 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n1 = new ListNode(9, n2);
        ListNode res = lc445.addTwoNumbers(n1, n3);
        ListNode.print(res);
    }
}
