package hard;

public class _188_MaxProfit {
    //优化后
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; ++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                //第k次, 持有股票
                dp[j - 1][1] = Math.max(dp[j - 1][1], dp[j - 1][0] - prices[i]);
                //第k次，不持有股票
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);

            }
        }
        return dp[k][0];
    }

    //未优化
    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        //dp[i][j][0]: 第i天第j次交易后不持有股票
        //dp[i][j][1]: 第i天第j次交易后持有股票
        int[][][] dp = new int[prices.length][k + 1][2];

        //初始化第一天数据
        for (int j = 0; j < k + 1; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        //初始化第i天第一次交易数据
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = -prices[i];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }

    public static void main(String[] args) {
        int profit = new _188_MaxProfit().maxProfit2(2, new int[]{2, 4, 1});
        System.out.println(profit);

        profit = new _188_MaxProfit().maxProfit2(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(profit);
    }
}
