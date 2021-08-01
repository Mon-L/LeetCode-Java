package easy;

public class _198_Rob {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        int curr = 0, prev = 0;
        for (int num : nums) {
            int temp = Math.max(prev + num, curr);

            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new _198_Rob().rob2(new int[]{2}));
        System.out.println(new _198_Rob().rob2(new int[]{1, 2, 3, 1}));
        System.out.println(new _198_Rob().rob2(new int[]{2, 7, 9, 3, 1}));
    }
}
