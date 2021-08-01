package easy;

public class _70_ClimbingStairs {

    private static int climbStairs(int n) {
        if (n < 2) return n;

        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;

        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
