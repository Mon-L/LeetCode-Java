package medium;

public class _688_KnightProbability {

    private static final int[][] directions = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    /**
     * 普通DFS
     */
    public double knightProbability_dfs(int n, int k, int row, int column) {
        return dfs(n, k, row, column);
    }

    private double dfs(int n, int k, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        double ret = 0;
        for (int[] d : directions) {
            ret += dfs(n, k - 1, x + d[0], y + d[1]) / 8.0;
        }

        return ret;
    }

    /**
     * 记忆化搜索
     */
    public double knightProbability_dfs_memo(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return dfs_memo(n, k, row, column, memo);
    }

    private double dfs_memo(int n, int k, int x, int y, double[][][] memo) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (memo[x][y][k] != 0) {
            return memo[x][y][k];
        }

        double ret = 0;
        for (int[] d : directions) {
            ret += dfs_memo(n, k - 1, x + d[0], y + d[1], memo) / 8.0;
        }

        memo[x][y][k] = ret;

        return ret;
    }

    /**
     * 动态规划
     */
    public double knightProbability_dp(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int z = 1; z <= k; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : directions) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= n || y >= n || x < 0 || y < 0) {
                            continue;
                        }

                        dp[i][j][z] += dp[x][y][z - 1] / 8.0;
                    }
                }
            }
        }

        return dp[row][column][k];
    }

    public static void main(String[] args) {
        System.out.println(new _688_KnightProbability().knightProbability_dp(3, 2, 0, 0));
    }
}
