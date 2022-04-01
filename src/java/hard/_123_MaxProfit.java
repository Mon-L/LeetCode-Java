package hard;

public class _123_MaxProfit {

    private int max;

    public int maxProfit(int[] prices) {
        dfs(prices, 0, 0, 0, 0);
        return max;
    }

    private void dfs(int[] prices, int i, int cnt, int status, int profit) {
        if ((cnt == 2 && status == 0) || i == prices.length) {
            max = Math.max(max, profit);
            return;
        }

        if (cnt < 2) {
            if (status == 0) {
                //买入
                dfs(prices, i + 1, cnt + 1, 1, profit - prices[i]);
            } else {
                //卖出
                dfs(prices, i + 1, cnt, 0, profit + prices[i]);
            }
        } else {
            if (status == 1) {
                //卖出
                dfs(prices, i + 1, cnt, 0, profit + prices[i]);
            }
        }

        //不操作
        dfs(prices, i + 1, cnt, status, profit);
    }

    public int maxProfit_dp(int[] prices) {
        if (prices.length <= 1) return 0;

        int n = prices.length;

        /**
         *  dp[i][j][k] 经过了第 i 天交易了第 j 次的状态 k 的最大收益;
         *  i ：第几天；
         *  j = 0, 交易没有发生； j = 1,第一轮交易；j = 2, 第二轮交易；
         *  k = 0, 不持有股票； k = 1，持有股票；
         */
        int[][][] dp = new int[n][3][2];

        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }
        }

        return Math.max(dp[n - 1][2][0], dp[n - 1][1][0]);
    }

    public static void main(String[] args) {
        System.out.println(new _123_MaxProfit().maxProfit_dp(new int[]{}));    //0
        System.out.println(new _123_MaxProfit().maxProfit_dp(new int[]{1}));   //0
        System.out.println(new _123_MaxProfit().maxProfit_dp(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));  //6
        System.out.println(new _123_MaxProfit().maxProfit_dp(new int[]{1, 2, 3, 4, 5}));   //4
        System.out.println(new _123_MaxProfit().maxProfit_dp(new int[]{7, 6, 4, 3, 1}));   //0
    }
}
