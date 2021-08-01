package easy;

import java.util.Arrays;

public class _344_ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char ch = s[i];
            s[i++] = s[j];
            s[j--] = ch;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        new _344_ReverseString().reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
