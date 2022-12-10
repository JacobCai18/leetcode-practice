package com.jacobcai.cc;

import java.util.HashMap;
import java.util.Map;

public class Lc146 {
    static class DoubleLinkedNode {
        int key;
        int val;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        
        public DoubleLinkedNode() {
        }
        
        public DoubleLinkedNode(int key,
                                int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private final Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DoubleLinkedNode dummyHead;
    private final DoubleLinkedNode dummyTail;
    
    public Lc146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部结点
        dummyHead = new DoubleLinkedNode();
        dummyTail = new DoubleLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key,
                    int val) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key,
                                                            val);
            cache.put(key,
                      newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DoubleLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }
    
    private void addToHead(DoubleLinkedNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }
    
    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    
    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode tail = dummyTail.prev;
        removeNode(tail);
        return tail;
    }
    
    public static void main(String[] args) {
        Lc146 lRUCache = new Lc146(2);
        lRUCache.put(1,
                     1);
        lRUCache.put(2,
                     2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3,
                     3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4,
                     4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
