package medium;

import model.UnionFindSet2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _1631_MinimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) return 0;

        int m = heights.length, n = heights[0].length, N = m * n;
        List<Edge> edges = new ArrayList<>(N);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = (i * n) + j;

                if (j < n - 1) {
                    edges.add(new Edge(curr, curr + 1, Math.abs(heights[i][j] - heights[i][j + 1])));
                }

                if (i < m - 1) {
                    edges.add(new Edge(curr, curr + n, Math.abs(heights[i][j] - heights[i + 1][j])));
                }
            }
        }

        edges.sort(Comparator.comparingInt(o -> o.len));

        UnionFindSet2 uf = new UnionFindSet2(N);
        for (Edge e : edges) {
            uf.union(e.x, e.y);

            if (uf.find(0) == uf.find(N - 1)) {
                return e.len;
            }
        }

        return 0;
    }

    private static class Edge {
        int x;
        int y;
        int len;

        private Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        int[][] heights;

        heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};  // 2
        System.out.println(new _1631_MinimumEffortPath().minimumEffortPath(heights));

        heights = new int[][]{{7, 9}, {3, 6}, {6, 9}, {3, 6}}; // 3
        System.out.println(new _1631_MinimumEffortPath().minimumEffortPath(heights));

        heights = new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}};  // 9
        System.out.println(new _1631_MinimumEffortPath().minimumEffortPath(heights));
    }
}
