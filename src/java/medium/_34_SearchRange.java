package medium;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int left = left(nums, target);

        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }

        int right = right(nums, target) - 1;
        return new int[]{left, right};
    }

    //找左边界
    private int left(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    //找右边界
    private int right(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] ans = new _34_SearchRange().searchRange(new int[]{5, 7, 8, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ans));
    }
}
