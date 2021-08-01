package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    private List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        doGenerateParenthesis(new char[2 * n], 0, result);
        return result;
    }

    private void doGenerateParenthesis(char[] current, int pos, List<String> result) {
        if (current.length == pos) {
            if (isValid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            doGenerateParenthesis(current, pos + 1, result);
            current[pos] = ')';
            doGenerateParenthesis(current, pos + 1, result);
        }
    }

    private boolean isValid(char[] parenthesis) {
        int flag = 0;
        for (char c : parenthesis) {
            if (c == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        return flag == 0;
    }

    private List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        doGenerateParenthesis2(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void doGenerateParenthesis2(List<String> result, StringBuilder current, int left, int right, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (left < max) {
            current.append('(');
            doGenerateParenthesis2(result, current, left + 1, right, max);
            current.deleteCharAt(current.length() - 1);
        }

        if (right < left) {
            current.append(')');
            doGenerateParenthesis2(result, current, left, right + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis2(3));
    }
}
