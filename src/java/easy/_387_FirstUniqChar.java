package easy;

public class _387_FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] mapping = new int[26];

        for (int i = 0; i < chars.length; i++) {
            mapping[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (mapping[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new _387_FirstUniqChar().firstUniqChar("leetcode"));
        System.out.println(new _387_FirstUniqChar().firstUniqChar("loveleetcode"));
    }
}
