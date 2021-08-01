package medium;

import java.util.Arrays;

public class _213_Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(
                doRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                doRob(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    private int doRob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int i : nums) {
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new _213_Rob2().rob(new int[]{0}));
        System.out.println(new _213_Rob2().rob(new int[]{2, 3, 2}));
        System.out.println(new _213_Rob2().rob(new int[]{1, 2}));
        System.out.println(new _213_Rob2().rob(new int[]{1, 2, 3, 1}));
    }
}
