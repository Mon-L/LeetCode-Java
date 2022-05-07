package medium;

public class _713_NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int l = 0, r = 0, mul = 1;
        while (r < nums.length && l <= r) {
            mul *= nums[r];
            while (mul >= k && l <= r) {
                mul /= nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _713_NumSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(new _713_NumSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(new _713_NumSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }
}
