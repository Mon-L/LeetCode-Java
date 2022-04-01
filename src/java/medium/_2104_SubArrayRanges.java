package medium;

/**
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2104_SubArrayRanges {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new _2104_SubArrayRanges().subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(new _2104_SubArrayRanges().subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(new _2104_SubArrayRanges().subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }
}
