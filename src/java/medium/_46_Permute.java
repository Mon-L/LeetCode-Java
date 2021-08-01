package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _46_Permute {

    //----------------普通回溯----------------
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
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

            visited[i] = true;
            deque.push(nums[i]);

            backtrack(nums, visited, deque, ans);

            visited[i] = false;
            deque.poll();
        }
    }
    //----------------普通回溯----------------


    //----------------空间优化--------------
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack2(nums, 0, ans);
        return ans;
    }

    private void backtrack2(int[] nums, int pos, List<List<Integer>> ans) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
        }

        for (int i = pos; i < nums.length; i++) {
            if (i != pos) swap(nums, i, pos);
            backtrack2(nums, pos + 1, ans);
            if (i != pos) swap(nums, i, pos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
    //----------------空间优化-------------

    public static void main(String[] args) {
        System.out.println(new _46_Permute().permute2(new int[]{1,2,3}));
    }
}
