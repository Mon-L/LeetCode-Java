package medium;

import java.util.HashMap;
import java.util.Map;

public class _1695_MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 0) return 0;

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        Map<Integer, Integer> M = new HashMap<>();
        int maxCount = 0, right = 0, left = 0;
        while (right < nums.length) {
            int num = nums[right];

            if (M.containsKey(num) && M.get(num) >= left) {
                left = M.get(num) + 1;
            } else {
                maxCount = Math.max(maxCount, left == 0 ? preSum[right] : preSum[right] - preSum[left - 1]);
            }
            M.put(num, right++);
        }

        return maxCount;
    }

    public int maximumUniqueSubarray2(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0, right = 0, sum = 0, max = 0;
        boolean[] visited = new boolean[10001];
        while (right < nums.length) {
            int num = nums[right++];
            if (visited[num]) {
                max = Math.max(sum, max);

                while (nums[left] != num) {
                    visited[nums[left]] = false;
                    sum -= nums[left];
                    left++;
                }
                left++;
            } else {
                sum += num;
                visited[num] = true;
            }
        }

        return Math.max(sum, max);
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{4, 2, 4, 5, 6}; // 17
        System.out.println(new _1695_MaximumUniqueSubarray().maximumUniqueSubarray2(nums));

        nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}; // 8
        System.out.println(new _1695_MaximumUniqueSubarray().maximumUniqueSubarray2(nums));

        nums = new int[]{10000, 1, 10000, 1, 1, 1, 1, 1, 1}; // 10001
        System.out.println(new _1695_MaximumUniqueSubarray().maximumUniqueSubarray2(nums));

        //16911
        nums = new int[]{187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434}; // 10001
        System.out.println(new _1695_MaximumUniqueSubarray().maximumUniqueSubarray2(nums));
    }
}
