package easy;

import java.util.Arrays;

public class _1984_MinimumDifference {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);

        int min = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new _1984_MinimumDifference().minimumDifference(new int[]{90}, 1));
        System.out.println(new _1984_MinimumDifference().minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }
}
