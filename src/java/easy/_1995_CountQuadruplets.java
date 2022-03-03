package easy;

public class _1995_CountQuadruplets {

    private int count;

    public int countQuadruplets(int[] nums) {
        recursion(0, nums, 0, 0);
        return count;
    }

    public void recursion(int curr, int[] nums, int sum, int len) {
        if (len == 3) {
            for (int i = curr; i < nums.length; i++) {
                if (sum == nums[i]) {
                    count++;
                }
            }

            return;
        }

        for (int i = curr; i < nums.length; i++) {
            sum += nums[i];
            recursion(i + 1, nums, sum, len + 1);
            sum -= nums[i];
        }
    }

    public int countQuadruplets2(int[] nums) {
        int count = 0;
        int[] cnt = new int[301];

        for (int i = nums.length - 2; i >= 2; i--) {
            cnt[nums[i + 1]]++;
            for (int a = 0; a < nums.length; a++) {
                for (int b = a + 1; b < i; b++) {
                    count += cnt[nums[a] + nums[b] + nums[i]];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _1995_CountQuadruplets().countQuadruplets2(new int[]{1, 2, 3, 6}));
        System.out.println(new _1995_CountQuadruplets().countQuadruplets2(new int[]{3, 3, 6, 4, 5}));
        System.out.println(new _1995_CountQuadruplets().countQuadruplets2(new int[]{1, 1, 1, 3, 5}));
        System.out.println(new _1995_CountQuadruplets().countQuadruplets2(new int[]{9, 6, 8, 23, 39, 23}));
    }
}
