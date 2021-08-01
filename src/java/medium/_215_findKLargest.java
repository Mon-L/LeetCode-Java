package medium;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class _215_findKLargest {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSearch(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSearch(int[] nums, int l, int r, int index) {
        int a = partition(nums, l, r);

        if (a == index) {
            return nums[a];
        }
        return a < index ? quickSearch(nums, a + 1, r, index) : quickSearch(nums, l, a - 1, index);
    }

    private int partition(int[] nums, int l, int r) {
        int index = random.nextInt(r - l + 1) + l;
        int num = nums[index];

        swap(nums, index, r);

        int slow = l - 1;
        int fast = l;
        for (; fast < r; fast++) {
            if (num > nums[fast]) {
                swap(nums, ++slow, fast);
            }
        }
        swap(nums, slow + 1, r);
        return slow + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new _215_findKLargest().findKthLargest(nums, 2));
    }
}
