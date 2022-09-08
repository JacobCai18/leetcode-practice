package com.jacobcai.ccc;

import com.jacobcai.ListNode;

public class Lc234 {
    public boolean isPalindrome(ListNode head) {
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode mid = findMiddle(head);
        ListNode tail = reverseList(mid.next);
        // 判断是否回文
        ListNode n1 = head;
        ListNode n2 = tail;
        boolean result = true;
        while (result && n2 != null) {
            if (n1.val != n2.val) {
                result = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 还原链表并返回结果
        mid.next = reverseList(tail);
        return result;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode n1, n2;
        n2 = new ListNode(2);
        n1 = new ListNode(1,
                          n2);
        Lc234 lc234 = new Lc234();
        boolean res = lc234.isPalindrome(n1);
        System.out.println("res = " + res);
    }
}
