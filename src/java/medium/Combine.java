package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, n, k, 1, new LinkedList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack(ans, n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
