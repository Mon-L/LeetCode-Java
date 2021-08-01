package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length(), i = 0, j = 0, max = 0;
        char[] chars = s.toCharArray();

        for (; j < len; j++) {
            for (int k = i; k < j; k++) {
                if (chars[k] == chars[j]) {
                    i = k + 1;
                    break;
                }
            }
            max = Math.max(j - i + 1, max);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0, len = s.length();

        Map<Character, Integer> map = new HashMap<>();
        while (i < len && j < len) {
            char temp = s.charAt(j);

            Integer prev = map.get(temp);
            if (prev == null || prev < i) {
                max = Math.max(max, j - i + 1);
            } else {
                i = prev + 1;
            }
            map.put(temp, j++);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba") == 2);
        System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(lengthOfLongestSubstring("tmmzuxt") == 5);
    }
}
