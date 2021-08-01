package medium;

import java.util.Arrays;

public class _1319_MakeConnected {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFindSet ufs = new UnionFindSet(n);
        for (int[] conn : connections) {
            ufs.union(conn[0], conn[1]);
        }

        return ufs.count - 1;
    }

    public static class UnionFindSet {

        int count;
        int[] ranks;
        int[] parents;

        public UnionFindSet(int n) {
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

    public static void main(String[] args) {
        int[][] connections;

        connections = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        System.out.println(new _1319_MakeConnected().makeConnected(4, connections));

        connections = new int[][]{{0, 1}, {0, 2}, {0, 3},{1,2},{1,3}};
        System.out.println(new _1319_MakeConnected().makeConnected(6, connections));

        connections = new int[][]{{0, 1}, {0, 2}, {0, 3},{1,2}};
        System.out.println(new _1319_MakeConnected().makeConnected(6, connections));
    }
}
