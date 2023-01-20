package com.jacobcai.dccc;

import com.jacobcai.ListNode;

public class Lc707 {
    private int size;
    private final ListNode head;

    public Lc707() {
        size = 0;
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        for (int i = 0; i <= index; i++) cur = cur.next;
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        index = Math.max(0, index);
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        pred.next = pred.next.next;
    }

    public static void main(String[] args) {
        Lc707 linkedList = new Lc707();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2); //链表变为1-> 2-> 3
        linkedList.get(1); //返回2
        linkedList.deleteAtIndex(1); //现在链表是1-> 3
        linkedList.get(1); //返回3
    }
}

