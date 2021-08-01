package medium;

import java.util.Arrays;

public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]) ;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new _322_CoinChange().coinChange(new int[]{2}, 1));
        System.out.println(new _322_CoinChange().coinChange(new int[]{2, 5, 10, 1}, 27));
        System.out.println(new _322_CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
