package easy.offer;

public class _53_2_MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new _53_2_MissingNumber().missingNumber(new int[]{0}));
        System.out.println(new _53_2_MissingNumber().missingNumber(new int[]{0, 1, 3}));
        System.out.println(new _53_2_MissingNumber().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

}
