package easy;

/**
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class _389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] mapping = new int[26];

        for (char ch : s.toCharArray()) {
            mapping[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (--mapping[ch - 'a'] < 0) {
                return ch;
            }
        }
        return 0;
    }

    public char findTheDifference2(String s, String t) {
        char ch = t.charAt(t.length() - 1);
        for (int i = 0, len = s.length(); i < len; i++) {
            ch ^= s.charAt(i);
            ch ^= t.charAt(i);
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(new _389_FindTheDifference().findTheDifference2("abcd", "abcde"));
        System.out.println(new _389_FindTheDifference().findTheDifference2("a", "aa"));
        System.out.println(new _389_FindTheDifference().findTheDifference2("", "y"));
        System.out.println(new _389_FindTheDifference().findTheDifference2("ae", "aae"));
    }
}
