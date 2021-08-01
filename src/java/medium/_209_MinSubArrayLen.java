package medium;

import java.util.Arrays;

public class _209_MinSubArrayLen {

    //双指针
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE, sum = 0;
        while (j < nums.length) {
            sum = nums[j] + sum;
            while (sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //前缀和 + 二分查找
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int ans = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= nums.length; i++) {
            int target = sums[i - 1] + s;
            int bound = Arrays.binarySearch(sums, target);

            if (bound < 0) {
                bound = -bound - 1;
            }

            if (bound <= nums.length) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
//        System.out.println(new _209_MinSubArrayLen().minSubArrayLen2(3, new int[]{}));
//        System.out.println(new _209_MinSubArrayLen().minSubArrayLen2(3, new int[]{1}));
//        System.out.println(new _209_MinSubArrayLen().minSubArrayLen2(3, new int[]{1, 1}));
        System.out.println(new _209_MinSubArrayLen().minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
