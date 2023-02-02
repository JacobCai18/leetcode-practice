package com.jacobcai.cc;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Lc133_2 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (var nei : n.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                visited.get(n).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
}