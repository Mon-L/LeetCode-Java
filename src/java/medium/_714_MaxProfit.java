package medium;

public class _714_MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int profit = new _714_MaxProfit().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(profit);
    }
}
