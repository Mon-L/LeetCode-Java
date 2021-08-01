package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _216_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayDeque<>(), k, n, 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, Deque<Integer> deque, int k, int n, int pos) {
        if (deque.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(deque));
            }
            return;
        }

        for (int i = pos; i <= 9 && n - i >= 0; i++) {
            deque.addLast(i);
            backtrack(ans, deque, k, n - i, i + 1);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _216_CombinationSum3().combinationSum3(3, 9));
    }
}
