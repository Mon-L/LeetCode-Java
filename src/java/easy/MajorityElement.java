package easy;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/description/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElementInRange(nums, 0, nums.length - 1);
    }

    public int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElementInRange(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (high - low) / 2 + low;
        int left = majorityElementInRange(nums, low, mid);
        int right = majorityElementInRange(nums, mid + 1, high);

        if (left == right) {
            return left;
        }

        int count_left = countInRange(nums, left, low, high);
        int count_right = countInRange(nums, right, low, high);

        return count_left > count_right ? left : right;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
