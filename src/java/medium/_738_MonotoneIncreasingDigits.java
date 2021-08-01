package medium;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class _738_MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();

        int flag = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new _738_MonotoneIncreasingDigits().monotoneIncreasingDigits(1234));
        System.out.println(new _738_MonotoneIncreasingDigits().monotoneIncreasingDigits(100));
        System.out.println(new _738_MonotoneIncreasingDigits().monotoneIncreasingDigits(9));
        System.out.println(new _738_MonotoneIncreasingDigits().monotoneIncreasingDigits(109));
        System.out.println(new _738_MonotoneIncreasingDigits().monotoneIncreasingDigits(79754));
    }
}
