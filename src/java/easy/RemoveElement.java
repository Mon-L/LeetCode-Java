package easy;

public class RemoveElement {

    private static int removeEle(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                if (i != j) {
                    nums[i] = nums[j];
                }
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeEle(nums, 2));
    }
}
