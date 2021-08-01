package medium;

import java.util.*;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_Permute2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new LinkedList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] visited, Deque<Integer> deque, List<List<Integer>> ans) {
        if (deque.size() == nums.length) {
            ans.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            deque.push(nums[i]);

            backtrack(nums, visited, deque, ans);

            visited[i] = false;
            deque.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _47_Permute2().permuteUnique(new int[]{2, 1, 1}));
    }
}
