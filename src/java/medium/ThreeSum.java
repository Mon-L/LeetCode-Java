package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> sum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (j++, k--; j < k && nums[j] == nums[j - 1]; j++);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(sum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(sum(new int[]{-2, 0, 0, 2, 2}));
    }
}
