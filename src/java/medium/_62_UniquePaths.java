package medium;

import java.util.Arrays;

public class _62_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        for (int i = n - 1; i >= 0; i--) {
            grid[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] = row[j] + row[j - 1];
            }
        }

        return row[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _62_UniquePaths().uniquePaths2(3, 2));
        System.out.println(new _62_UniquePaths().uniquePaths2(7, 3));
    }
}
