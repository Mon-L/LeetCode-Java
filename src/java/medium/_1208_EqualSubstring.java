package medium;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 */
public class _1208_EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0, sl = 0, sr = 0, maxLen = 0, len = s.length();

        char[] s_chars = s.toCharArray(), t_chars = t.toCharArray();

        int[] diff = new int[len];

        for (int i = 0; i < len; i++) {
            diff[i] = Math.abs(s_chars[i] - t_chars[i]);
        }

        while (sr < len) {
            cost += diff[sr++];

            while (cost > maxCost) {
                cost -= diff[sl++];
            }

            maxLen = Math.max(maxLen, sr - sl);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new _1208_EqualSubstring().equalSubstring("abcd", "bcdf", 3)); //3
        System.out.println(new _1208_EqualSubstring().equalSubstring("abcd", "cdef", 3)); //1
        System.out.println(new _1208_EqualSubstring().equalSubstring("abcd", "acde", 0)); //1
    }
}
