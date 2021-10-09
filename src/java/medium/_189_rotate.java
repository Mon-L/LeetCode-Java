package medium;

import java.util.Arrays;

public class _189_rotate {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k > len) k %= len;
        if (k == 0) return;

        reserve(nums, 0, len);
        reserve(nums, 0, k);
        reserve(nums, k, len);
    }

    private void reserve(int[] nums, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new _189_rotate().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
