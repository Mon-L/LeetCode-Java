package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1584_MinCostConnectPoints {

    /**
     * Kruskal 算法
     *
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.len));

        int ret = 0;
        DisjointSetUnion union = new DisjointSetUnion(N);
        for (Edge edge : edges) {
            if (union.unionSet(edge.x, edge.y)) {
                ret += edge.len;

                if (union.count == 1) {
                    break;
                }
            }

        }
        return ret;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    /**
     * 并查集
     */
    private static class DisjointSetUnion {
        int[] parents;
        int[] ranks;
        int count;

        public DisjointSetUnion(int count) {
            this.count = count;
            this.ranks = new int[count];
            Arrays.fill(this.ranks, 1);
            this.parents = new int[count];
            for (int i = 0; i < count; i++) {
                this.parents[i] = i;
            }
        }

        public int find(int x) {
            return parents[x] == x ? x : (parents[x] = find(parents[x]));
        }

        public boolean unionSet(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return false;
            }

            if (ranks[rootX] < ranks[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }

            ranks[rootX] += ranks[rootY];
            parents[rootY] = rootX;

            count--;

            return true;
        }
    }

    private static class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        };
        System.out.println(new _1584_MinCostConnectPoints().minCostConnectPoints(points));

        points = new int[][]{
                {3, 12}, {-2, 5}, {-4, 1}
        };
        System.out.println(new _1584_MinCostConnectPoints().minCostConnectPoints(points));

        points = new int[][]{
                {-1000000, -1000000}, {1000000, 1000000}
        };
        System.out.println(new _1584_MinCostConnectPoints().minCostConnectPoints(points));

        points = new int[][]{
                {0, 0}
        };
        System.out.println(new _1584_MinCostConnectPoints().minCostConnectPoints(points));

    }
}
