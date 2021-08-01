package easy.offer;

public class _53_1_Search {
    public int search(int[] nums, int target) {
        return findRightBound(nums, target) - findRightBound(nums, target - 1);
    }

    private int findRightBound(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        //右边界
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        System.out.println(new _53_1_Search().search(array, 8));
    }
}
