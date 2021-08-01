package medium;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    private static final String[] MAPPING = {"*", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();

        List<String> ans = new LinkedList<>();
        doIt(ans, digits, new char[digits.length()], 0);
        return ans;
    }

    public void doIt(List<String> ans, String digits, char[] sb, int index) {
        if (index > digits.length() - 1) {
            ans.add(new String(sb));
            return;
        }

        String digit = MAPPING[digits.charAt(index) - '0'];
        int length = digit.length();

        for (int j = 0; j < length; j++) {
            sb[index] = digit.charAt(j);
            doIt(ans, digits, sb, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
