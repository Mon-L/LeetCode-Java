package easy;

/**
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
public class _1370_sortString {
    public String sortString(String s) {
        int[] bucket = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            bucket[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        while (s.length() > ans.length()) {
            for (int i = 0; i <= 25; i++) {
                if (bucket[i] > 0) {
                    ans.append((char) (i + 'a'));
                    bucket[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (bucket[i] > 0) {
                    ans.append((char) (i + 'a'));
                    bucket[i]--;
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _1370_sortString().sortString("aaaabbbbcccc"));
        System.out.println(new _1370_sortString().sortString("rat"));
        System.out.println(new _1370_sortString().sortString("leetcode"));
        System.out.println(new _1370_sortString().sortString("gggggg"));
    }
}
