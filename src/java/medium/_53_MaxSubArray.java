package medium;

public class _53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _53_MaxSubArray().maxSubArray(new int[]{1}));
        System.out.println(new _53_MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
