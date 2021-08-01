package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(ans, candidates, target, 0, 0, new LinkedList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, int pos, int sum, LinkedList<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos, len = candidates.length; i < len; i++) {
            int num = candidates[i];
            if (num <= target && sum + num <= target) {
                list.add(num);
                backtrack(ans, candidates, target, i, sum + num, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _39_CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
