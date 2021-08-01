package medium;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class _309_MaxProfit {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];

        dp[0][0] = -prices[0];  //持有股票
        dp[0][1] = 0;   //无股票，且在冷冻期内
        dp[0][2] = 0;   //无股票，不在冷冻期内

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        int profit = new _309_MaxProfit().maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(profit);
    }
}
