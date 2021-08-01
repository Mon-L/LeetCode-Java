package easy.interview;

public class _17_16_Massage {
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public int massage2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int temp = Math.max(a + num, b);
            a = b;
            b = temp;
        }
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        System.out.println(new _17_16_Massage().massage(new int[]{2}));
        System.out.println(new _17_16_Massage().massage(new int[]{1, 2}));
        System.out.println(new _17_16_Massage().massage(new int[]{2, 7, 9, 3, 1}));
    }
}
