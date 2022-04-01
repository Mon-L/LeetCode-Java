package medium;

public class _2044_CountMaxOrSubsets {
    private int max = 0;
    private int cnt = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int i : nums) {
            max |= i;
        }
        dfs(nums, 0, 0);
        return cnt;
    }

    private void dfs(int[] nums, int i, int sum) {
        if (sum == max) {
            cnt += 1 << (nums.length - i);
            return;
        }

        if (i >= nums.length) {
            return;
        }

        dfs(nums, i + 1, sum | nums[i]);
        dfs(nums, i + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(new _2044_CountMaxOrSubsets().countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(new _2044_CountMaxOrSubsets().countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(new _2044_CountMaxOrSubsets().countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }
}
