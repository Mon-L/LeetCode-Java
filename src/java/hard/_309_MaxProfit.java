package hard;

public class _309_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        // f[i][0]: 经过第i天，手上不持有股票，并且第二天不在冷冻期中的累计最大收益
        // f[i][1]: 经过第i天，手上持有股票的最大收益
        // f[i][2]: 经过第i天，手上不持有股票，并且第二天处于冷冻期中的累计最大收益
        int[][] dp = new int[prices.length][3];

        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        System.out.println(new _309_MaxProfit().maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
        System.out.println(new _309_MaxProfit().maxProfit(new int[]{0}));  // 0
    }
}
