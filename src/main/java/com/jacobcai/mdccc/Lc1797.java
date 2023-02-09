package com.jacobcai.mdccc;

import java.util.HashMap;
import java.util.Map;

public class Lc1797 {
    private static class Node {
        String tokenId;
        int expiredTime;
        Node prev;
        Node next;

        public Node(int expiredTime) {
            this(null, expiredTime, null, null);
        }

        public Node(String tokenId, int expiredTime) {
            this(tokenId, expiredTime, null, null);
        }

        public Node(String tokenId, int expiredTime, Node prev, Node next) {
            this.tokenId = tokenId;
            this.expiredTime = expiredTime;
            this.prev = prev;
            this.next = next;
        }
    }

    int timeToLive;
    Node head;
    Node tail;
    Map<String, Node> tokenId2Node;

    public Lc1797(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.tokenId2Node = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(tokenId, currentTime + timeToLive);
        tokenId2Node.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public void renew(String tokenId, int currentTime) {
        if (tokenId2Node.containsKey(tokenId) && tokenId2Node.get(tokenId).expiredTime > currentTime) {
            Node node = tokenId2Node.get(tokenId);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.expiredTime = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expiredTime > 0 && head.next.expiredTime <= currentTime) {
            Node node = head.next;
            tokenId2Node.remove(node.tokenId);
            head.next = node.next;
            node.next.prev = head;
        }
        return tokenId2Node.size();
    }
}
