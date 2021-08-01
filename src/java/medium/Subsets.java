package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        doIt(nums, 0, ans, new LinkedList<>());
        return ans;
    }

    private void doIt(int[] nums, int i, List<List<Integer>> ans, List<Integer> current) {
        if (i == nums.length) {
            ans.add(current);
            return;
        }

        List<Integer> temp = new LinkedList<>(current);

        current.add(nums[i]);
        doIt(nums, i + 1, ans, current);

        current = temp;
        doIt(nums, i + 1, ans, current);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
