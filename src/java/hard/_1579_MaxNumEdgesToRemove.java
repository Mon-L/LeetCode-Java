package hard;

import java.util.Arrays;

public class _1579_MaxNumEdgesToRemove {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ret = 0;

        UnionFind aliceUf = new UnionFind(n);
        UnionFind bobUf = new UnionFind(n);

        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean flag1 = aliceUf.union(e[1] - 1, e[2] - 1);
                boolean flag2 = bobUf.union(e[1] - 1, e[2] - 1);

                if (!flag1 && !flag2) ret++;
            }
        }

        for (int[] e : edges) {
            if (e[0] == 1 && !aliceUf.union(e[1] - 1, e[2] - 1)) {
                ret++;
            }

            if (e[0] == 2 && !bobUf.union(e[1] - 1, e[2] - 1)) {
                ret++;
            }
        }

        return aliceUf.count != 1 || bobUf.count != 1 ? -1 : ret;
    }

    private static class UnionFind {

        private int count;
        private int[] ranks;
        private int[] parents;

        public UnionFind(int n) {
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

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (ranks[rootX] < ranks[rootY]) {
                int temp = rootY;
                rootY = rootX;
                rootX = temp;
            }
            ranks[rootX] += ranks[rootY];

            parents[rootX] = rootY;
            count--;
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] edges;

        edges = new int[][]{
                {3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}
        };
        System.out.println(new _1579_MaxNumEdgesToRemove().maxNumEdgesToRemove(4, edges));

        edges = new int[][]{
                {3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}
        };
        System.out.println(new _1579_MaxNumEdgesToRemove().maxNumEdgesToRemove(4, edges));

        edges = new int[][]{
                {3, 2, 3}, {1, 1, 2}, {2, 3, 4}
        };
        System.out.println(new _1579_MaxNumEdgesToRemove().maxNumEdgesToRemove(4, edges));

        edges = new int[][]{
                {1, 1, 2}, {2, 1, 2}, {3, 1, 2}
        };
        System.out.println(new _1579_MaxNumEdgesToRemove().maxNumEdgesToRemove(2, edges));
    }
}
