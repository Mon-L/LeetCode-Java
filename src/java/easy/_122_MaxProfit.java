package easy;

public class _122_MaxProfit {
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[dp.length - 1][0];
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp1 + prices[i], dp0);
            dp1 = Math.max(dp0 - prices[i], dp1);
        }
        return dp0;
    }

    public static void main(String[] args) {
        System.out.println(new _122_MaxProfit().maxProfit(new int[]{}));
        System.out.println(new _122_MaxProfit().maxProfit(new int[]{1}));
        System.out.println(new _122_MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new _122_MaxProfit().maxProfit(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new _122_MaxProfit().maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
