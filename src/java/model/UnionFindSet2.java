package model;

import java.util.Arrays;

public class UnionFindSet2 {

    private int count;
    private int[] ranks;
    private int[] parents;

    public UnionFindSet2(int n) {
        this.count = n;

        this.ranks = new int[n];
        Arrays.fill(ranks, 1);

        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            this.parents[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public int find(int x) {
        while (x != parents[x]) {
            x = parents[x] = parents[parents[x]];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (ranks[rootX] < ranks[rootY]) {
            int temp = rootY;
            rootY = rootX;
            rootX = temp;
        }
        ranks[rootX] += ranks[rootY];

        parents[rootX] = rootY;
        count--;
    }
}
