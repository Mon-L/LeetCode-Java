package model;

import java.util.Arrays;

public class Utils {
    public static String twoDimensionalArray2String(int[][] arr) {
        if (arr == null)
            return "null";

        int m = arr.length;
        if (m == 0) {
            return "[]";
        }

        int n = arr[0].length;

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(Arrays.toString(arr[i]));
            if (i == n - 1)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
