package medium;

import java.util.Arrays;

public class _1706_FindBall {

    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            while (x < m) {
                int curr = grid[x][y];
                y += grid[x][y];

                if (y < 0 || y >= n || curr != grid[x][y]) {
                    break;
                }
                x++;
            }

            ans[i] = x == m ? y : -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };

        System.out.println(Arrays.toString(new _1706_FindBall().findBall(grid))); // [1, -1, -1, -1, -1]

        grid = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        };

        System.out.println(Arrays.toString(new _1706_FindBall().findBall(grid)));  // [0, 1, 2, 3, 4, -1]
    }
}
