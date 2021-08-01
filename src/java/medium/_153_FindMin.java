package medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class _153_FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new _153_FindMin().findMin(new int[]{1, 2}));
        System.out.println(new _153_FindMin().findMin(new int[]{2, 1}));
        System.out.println(new _153_FindMin().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new _153_FindMin().findMin(new int[]{4, 0, 1, 2, 3}));
    }
}
