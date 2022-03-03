package medium;

public class _504_SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }

    public static void main(String[] args) {
        System.out.println(new _504_SingleNonDuplicate().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(new _504_SingleNonDuplicate().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
