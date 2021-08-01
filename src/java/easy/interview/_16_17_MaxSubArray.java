package easy.interview;

public class _16_17_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = dp[1] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new _16_17_MaxSubArray().maxSubArray(new int[]{-1}));
        System.out.println(new _16_17_MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
