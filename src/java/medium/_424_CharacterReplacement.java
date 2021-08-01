package medium;

public class _424_CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] M = new int[26];
        int l = 0, r = 0, max = 0, len = s.length();
        while (r < len) {
            max = Math.max(max, ++M[s.charAt(r) - 'A']);

            if (r - l + 1 - max > k) {
                M[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        System.out.println(new _424_CharacterReplacement().characterReplacement("ABAB", 2));
        System.out.println(new _424_CharacterReplacement().characterReplacement("AABABBA", 1));
    }

}
