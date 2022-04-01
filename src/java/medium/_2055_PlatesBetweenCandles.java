package medium;

import java.util.Arrays;

public class _2055_PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n], left = new int[n], right = new int[n];

        for (int i = 0, j = n - 1, l = -1, r = -1, sum = 0; i < n; i++, j--) {
            if (s.charAt(i) == '|') l = i;
            left[i] = l;

            if (s.charAt(j) == '|') r = j;
            right[j] = r;

            if (s.charAt(i) == '*') sum++;
            preSum[i] = sum;
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int a = right[l], b = left[r];
            if (a != -1 && b != -1 && b > a) {
                ret[i] = preSum[b] - preSum[a];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _2055_PlatesBetweenCandles().platesBetweenCandles("**|**|***|", new int[][]{
                {2, 5}, {5, 9}})));

        System.out.println(Arrays.toString(new _2055_PlatesBetweenCandles().platesBetweenCandles("***|**|*****|**||**|*", new int[][]{
                {1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
    }
}
