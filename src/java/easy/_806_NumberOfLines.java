package easy;

import java.util.Arrays;

public class _806_NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        int[] ret = new int[2];

        if (s.isEmpty()) {
            return ret;
        }

        int count = 1, lastRow = 0;
        for (char ch : s.toCharArray()) {
            int w = widths[ch - 'a'];
            if (lastRow + w > 100) {
                lastRow = w;
                ret[0]++;
            } else {
                lastRow += w;
            }
        }

        return new int[]{count, lastRow};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _806_NumberOfLines().numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "")));
        System.out.println(Arrays.toString(new _806_NumberOfLines().numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(new _806_NumberOfLines().numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa")));
    }
}
