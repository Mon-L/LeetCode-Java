package easy;

public class _122_MaxProfit {
    private int max = Integer.MIN_VALUE;

    public int maxProfit_dfs(int[] prices) {
        dfs(prices, 0, 0, 0);
        return max;
    }

    private void dfs(int[] prices, int i, int status, int profit) {
        if (i == prices.length) {
            max = Math.max(profit, max);
            return;
        }

        //不操作
        dfs(prices, i + 1, status, profit);

        if (status == 0) {
            //买
            dfs(prices, i + 1, 1, profit - prices[i]);
        } else {
            //卖
            dfs(prices, i + 1, 0, profit + prices[i]);
        }
    }

    public int maxProfit_dp(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][2];  //经过第 i 天时状态 j 的最大收益, j = 0 不持有股票， j = 1 持有股票

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new _122_MaxProfit().maxProfit_dp(new int[]{}));  // 0
        System.out.println(new _122_MaxProfit().maxProfit_dp(new int[]{1}));  // 0
        System.out.println(new _122_MaxProfit().maxProfit_dp(new int[]{7, 1, 5, 3, 6, 4}));  // 7
        System.out.println(new _122_MaxProfit().maxProfit_dp(new int[]{5, 4, 3, 2, 1})); // 0
        System.out.println(new _122_MaxProfit().maxProfit_dp(new int[]{1, 2, 3, 4, 5}));  // 4
    }
}
