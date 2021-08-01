package medium;

/**
 * 162. 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class _162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new _162_FindPeakElement().findPeakElement(new int[]{1}));
        System.out.println(new _162_FindPeakElement().findPeakElement(new int[]{1, 2}));
        System.out.println(new _162_FindPeakElement().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
