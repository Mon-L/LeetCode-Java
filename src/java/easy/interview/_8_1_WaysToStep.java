package easy.interview;

/**
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class _8_1_WaysToStep {
    public int waysToStep(int n) {
        if (n < 3) return n;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int) dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _8_1_WaysToStep().waysToStep(2));
        System.out.println(new _8_1_WaysToStep().waysToStep(3));
        System.out.println(new _8_1_WaysToStep().waysToStep(5));
        System.out.println(new _8_1_WaysToStep().waysToStep(61));
    }
}
