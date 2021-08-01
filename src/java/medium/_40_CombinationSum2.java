package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _40_CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, candidates, target, 0, new LinkedList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, int pos, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            int num = candidates[i];
            if (target - num < 0) {
                break;
            }

            if (i > pos && candidates[i] == candidates[i - 1]) { //在同一层不能选择相同元素
                continue;
            }

            list.add(num);
            backtrack(ans, candidates, target - num, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new _40_CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(ans);
    }
}
