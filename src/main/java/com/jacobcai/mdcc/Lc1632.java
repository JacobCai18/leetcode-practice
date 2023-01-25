package com.jacobcai.mdcc;

import java.util.*;

import static java.util.Collections.sort;

class UnionFind {
    int[] uf, sz;

    UnionFind(int n) {
        uf = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; ++i) {
            uf[i] = i;
            sz[i] = 1;
        }
    }

    int find(int p) {
        if (uf[p] == p) return p;
        return uf[p] = find(uf[p]);
    }

    void merge(int p, int q) {
        p = find(p);
        q = find(q);
        if (p != q) {
            if (sz[p] >= sz[q]) {
                uf[q] = p;
                sz[p] += sz[q];
            } else {
                uf[p] = q;
                sz[q] += sz[p];
            }
        }
    }
}

public class Lc1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        UnionFind uf = new UnionFind(m * n); // 用并查集将 rank 相同的元素合并
        for (int i = 0; i < m; i++) { // 同一行从左到右合并相同元素
            Map<Integer, List<Integer>> num2idxList = new HashMap<>(); // 一个元素对应所有相等元素的下标
            for (int j = 0; j < n; j++) {
                num2idxList.putIfAbsent(matrix[i][j], new ArrayList<>());
                num2idxList.get(matrix[i][j]).add(i * n + j);
            }
            for (var entry : num2idxList.entrySet()) {
                var idxList = entry.getValue();
                int idx1 = idxList.get(0);
                for (int k = 1; k < idxList.size(); k++) {
                    int idx2 = idxList.get(k);
                    uf.merge(idx1, idx2);
                }
            }
        }
        for (int j = 0; j < n; j++) { // 同一列从上到下合并相同元素
            Map<Integer, List<Integer>> num2idxList = new HashMap<>();
            for (int i = 0; i < m; i++) {
                num2idxList.putIfAbsent(matrix[i][j], new ArrayList<>());
                num2idxList.get(matrix[i][j]).add(i * n + j);
            }
            for (var entry : num2idxList.entrySet()) {
                var idxList = entry.getValue();
                int idx1 = idxList.get(0);
                for (int k = 1; k < idxList.size(); k++) {
                    int idx2 = idxList.get(k);
                    uf.merge(idx1, idx2);
                }
            }
        }

        int[] inDegree = new int[m * n]; // 入度数组
        Map<Integer, List<Integer>> adj = new HashMap<>(); // 邻接表 <该元素并查集头下标, 下一个比它大的元素的并查集头下标>
        for (int i = 0; i < m; i++) { // 同一行从左到右由较小元素指向较大元素
            Map<Integer, Integer> num2idx = new HashMap<>(); // 一个元素对应一个下标就行
            for (int j = 0; j < n; j++)
                num2idx.put(matrix[i][j], i * n + j);
            List<Integer> sortedArr = new ArrayList<>(num2idx.keySet());
            sort(sortedArr);
            for (int k = 1; k < sortedArr.size(); k++) {
                int i1 = num2idx.get(sortedArr.get(k - 1));
                int i2 = num2idx.get(sortedArr.get(k));
                int ri1 = uf.find(i1);
                int ri2 = uf.find(i2);
                inDegree[ri2]++; // 较大元素并查集根结点入度 + 1
                adj.putIfAbsent(ri1, new ArrayList<>());
                adj.get(ri1).add(ri2); // 较小元素并查集根结点 -> 较大元素并查集根结点
            }
        }
        for (int j = 0; j < n; j++) {
            Map<Integer, Integer> num2idx = new HashMap<>();
            for (int i = 0; i < m; i++)
                num2idx.put(matrix[i][j], i * n + j);
            List<Integer> sortedArr = new ArrayList<>(num2idx.keySet());
            sort(sortedArr);
            for (int k = 1; k < sortedArr.size(); k++) {
                int i1 = num2idx.get(sortedArr.get(k - 1));
                int i2 = num2idx.get(sortedArr.get(k));
                int ri1 = uf.find(i1);
                int ri2 = uf.find(i2);
                inDegree[ri2]++;
                adj.putIfAbsent(ri1, new ArrayList<>());
                adj.get(ri1).add(ri2);
            }
        }

        Set<Integer> rootSet = new HashSet<>(); // 并查集根结点集
        int[] ranks = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            int ri = uf.find(i);
            rootSet.add(ri); // 加入并查集根结点
            ranks[ri] = 1; // 并查集根结点的 rank 初始化为 1
        }
        Queue<Integer> q = new ArrayDeque<>(); // 拓扑排序
        for (int ri : rootSet)
            if (inDegree[ri] == 0)
                q.offer(ri); // 在队列中填入入度为 0 的并查集根结点
        while (!q.isEmpty()) {
            int ri = q.poll();
            if (adj.get(ri) == null) continue; // 跳过出度为 0 的元素
            for (int succ : adj.get(ri)) {
                if (--inDegree[succ] == 0)
                    q.offer(succ);
                ranks[succ] = Math.max(ranks[succ], ranks[ri] + 1); // 下一层的 rank 为所有指向该层的最大 rank + 1
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m * n; i++) {
            int ri = uf.find(i);
            res[i / n][i % n] = ranks[ri]; // 每个并查集的所有元素的 rank 为该并查集根结点的 rank
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1632 lc1632 = new Lc1632();
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] res = lc1632.matrixRankTransform(matrix);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
