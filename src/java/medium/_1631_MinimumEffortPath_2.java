package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1631_MinimumEffortPath_2 {

    private final static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) return 0;

        int m = heights.length, n = heights[0].length;

        boolean[][] visited = new boolean[m][n];

        int[][] lowCost = new int[m][n];
        for (int[] i : lowCost) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        lowCost[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1], d = p[2];

            if (x == m - 1 && y == n - 1) break;

            if (visited[x][y]) continue;

            visited[x][y] = true;

            for (int i = 0; i < directions.length; i++) {
                int ix = x + directions[i][0], iy = y + directions[i][1];

                if (ix >= 0 && ix < m && iy >= 0 && iy < n) {
                    int id = Math.max(Math.abs(heights[ix][iy] - heights[x][y]), d);
                    if (id < lowCost[ix][iy]) {
                        lowCost[ix][iy] = id;
                        queue.offer(new int[]{ix, iy, id});
                    }
                }
            }
        }
        return lowCost[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] heights;

        heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};  // 2
        System.out.println(new _1631_MinimumEffortPath_2().minimumEffortPath(heights));

        heights = new int[][]{{7, 9}, {3, 6}, {6, 9}, {3, 6}}; // 3
        System.out.println(new _1631_MinimumEffortPath_2().minimumEffortPath(heights));

        heights = new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}};  // 9
        System.out.println(new _1631_MinimumEffortPath_2().minimumEffortPath(heights));
    }
}
