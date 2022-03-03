package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        doIt(n, 0, 0, ans, 0, new char[n << 1]);
        return ans;
    }

    private void doIt(int n, int left, int right, List<String> ans, int pos, char[] chs) {
        if (left > n || left < right) {
            return;
        }

        if (left + right == n << 1) {
            ans.add(new String(chs));
            return;
        }

        chs[pos] = '(';
        doIt(n, left + 1, right, ans, pos + 1, chs);

        chs[pos] = ')';
        doIt(n, left, right + 1, ans, pos + 1, chs);
    }

    public static void main(String[] args) {
        // "((()))","(()())","(())()","()(())","()()()"
        System.out.println(new _22_GenerateParenthesis().generateParenthesis(3));

        // ["()"]
        System.out.println(new _22_GenerateParenthesis().generateParenthesis(1));
    }
}
