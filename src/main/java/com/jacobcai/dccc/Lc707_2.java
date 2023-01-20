package com.jacobcai.dccc;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Lc707_2 {
    private int size;
    private final ListNode head;
    private final ListNode tail;

    public Lc707_2() {
        size = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr;
        if (index + 1 < size - index) {
            curr = head;
            for (int i = 0; i <= index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) curr = curr.prev;
        }
        return curr.val;
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
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) pred = pred.next;
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++) succ = succ.prev;
            pred = succ.prev;
        }
        size++;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    public void deleteAtIndex(int idx) {
        if (idx < 0 || idx >= size) return;
        ListNode pred, succ;
        if (idx < size - idx) {
            pred = head;
            for (int i = 0; i < idx; i++) pred = pred.next;
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - idx - 1; i++) succ = succ.prev;
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }

    public static void main(String[] args) {
        Lc707_2 linkedList = new Lc707_2();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2); //链表变为1-> 2-> 3
        linkedList.get(1); //返回2
        linkedList.deleteAtIndex(1); //现在链表是1-> 3
        linkedList.get(1); //返回3
    }
}

