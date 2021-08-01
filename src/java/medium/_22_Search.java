package medium;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class _22_Search {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new _22_Search().search(new int[]{1}, 0));
        System.out.println(new _22_Search().search(new int[]{1, 3}, 0));
        System.out.println(new _22_Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new _22_Search().search(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 1));
        System.out.println(new _22_Search().search(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 7));
        System.out.println(new _22_Search().search(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 9));
    }
}
