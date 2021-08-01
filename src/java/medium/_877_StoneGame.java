package medium;

public class _877_StoneGame {
    public static boolean stoneGame(int[] piles) {
        int right = piles.length / 2;
        int left = right - 1;

        int[] stones = new int[2];
        while (right < piles.length) {
            if (piles[right] > piles[left]) {
                stones[0] += piles[right++];
                stones[1] += piles[left--];
            } else {
                stones[0] += piles[left--];
                stones[1] += piles[right++];
            }
        }

        return stones[0] > stones[1];
    }

    public static boolean stoneGame2(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public static void main(String[] args) {
        System.out.println(_877_StoneGame.stoneGame2(new int[]{3, 2, 10, 4}));
        System.out.println(_877_StoneGame.stoneGame2(new int[]{5, 3, 4, 5}));
    }
}
