package medium;

import java.util.Arrays;

public class _75_SortColors {
    public void sortColors(int[] nums) {
        int slow = 0, fast = nums.length - 1, index = 0;
        while (index <= fast) {
            if (nums[index] == 0) {
                nums[index++] = nums[slow];
                nums[slow++] = 0;
            } else if (nums[index] == 2) {
                nums[index] = nums[fast];
                nums[fast--] = 2;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        new _75_SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
