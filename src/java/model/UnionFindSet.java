package model;

public class UnionFindSet {

    private int count;
    private int[] parents;

    public UnionFindSet(int n) {
        this.count = n;
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

        parents[rootX] = rootY;
        count--;
    }
}
