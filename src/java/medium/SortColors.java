package medium;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int i = 0, k = 0, j = nums.length - 1;
        while (k <= j) {
            int curr = nums[k];
            if (curr == 0) {
                nums[k++] = nums[i];
                nums[i++] = curr;
            } else if (curr == 2) {
                nums[k] = nums[j];
                nums[j--] = curr;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
