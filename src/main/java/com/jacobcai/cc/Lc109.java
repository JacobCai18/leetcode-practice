package com.jacobcai.cc;

import com.jacobcai.ListNode;
import com.jacobcai.TreeNode;

public class Lc109 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head,
                               null);
    }
    
    /**
     * @param le 左闭
     * @param ri 右开
     *
     * @return 根结点
     */
    private TreeNode sortedListToBST(ListNode le,
                                     ListNode ri) {
        if (le == ri) {
            return null;
        }
        ListNode mid = getMid(le,
                              ri);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(le,
                                    mid);
        root.right = sortedListToBST(mid.next,
                                     ri);
        return root;
    }
    
    private ListNode getMid(ListNode le,
                            ListNode ri) {
        ListNode slow, fast;
        slow = fast = le;
        while (fast != ri && fast.next != ri) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode n5 = new ListNode(9);
        ListNode n4 = new ListNode(5,
                                   n5);
        ListNode n3 = new ListNode(0,
                                   n4);
        ListNode n2 = new ListNode(-3,
                                   n3);
        ListNode n1 = new ListNode(-10,
                                   n2);
        Lc109 lc109 = new Lc109();
        TreeNode res = lc109.sortedListToBST(n1);
        TreeNode.print(res);
    }
}
