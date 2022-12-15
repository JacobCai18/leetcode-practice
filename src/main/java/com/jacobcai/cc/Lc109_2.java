package com.jacobcai.cc;

import com.jacobcai.ListNode;
import com.jacobcai.TreeNode;

public class Lc109_2 {
    ListNode globalHead;
    
    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int len = getLen(head);
        return sortedListToBST(0,
                               len - 1);
    }
    
    private int getLen(ListNode head) {
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }
    
    /**
     * @param le 左闭
     * @param ri 右闭
     *
     * @return 根结点
     */
    private TreeNode sortedListToBST(int le,
                                     int ri) {
        if (le > ri) {
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = (le + ri) >>> 1;
        root.left = sortedListToBST(le,
                                    mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = sortedListToBST(mid + 1,
                                     ri);
        return root;
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
        Lc109_2 lc109_2 = new Lc109_2();
        TreeNode res = lc109_2.sortedListToBST(n1);
        TreeNode.print(res);
    }
}
