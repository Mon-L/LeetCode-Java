package easy;

public class _746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public int minCostClimbingStairs2(int[] costs) {
        int a = 0, b = 0;
        for (int cost : costs) {
            int temp = Math.min(a, b) + cost;
            a = b;
            b = temp;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(new _746_MinCostClimbingStairs().minCostClimbingStairs(new int[]{1}));
        System.out.println(new _746_MinCostClimbingStairs().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new _746_MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
