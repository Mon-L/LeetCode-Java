package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        backtrack(n, 0, 0, 0, ans, new char[n << 1]);
        return ans;
    }

    private void backtrack(int n, int index, int left, int right, List<String> ans, char[] chars) {
        if (left > n || right > left) {
            return;
        }

        if (index == n << 1) {
            ans.add(new String(chars));
            return;
        }

        chars[index] = '(';
        backtrack(n, index + 1, left + 1, right, ans, chars);
        chars[index] = ')';
        backtrack(n, index + 1, left, right + 1, ans, chars);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
