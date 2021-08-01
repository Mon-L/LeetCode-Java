package easy;

public class _724_PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - (left * 2) == nums[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(new _724_PivotIndex().pivotIndex(nums));

        nums = new int[]{1, 2, 3};
        System.out.println(new _724_PivotIndex().pivotIndex(nums));

        nums = new int[]{-1, -1, -1, -1, -1, 0};
        System.out.println(new _724_PivotIndex().pivotIndex(nums));
    }
}
