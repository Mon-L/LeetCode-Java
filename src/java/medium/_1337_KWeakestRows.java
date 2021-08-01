package medium;

import java.util.Arrays;
import java.util.Comparator;

public class _1337_KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int index = 0;
        int[] ret = new int[k];
        boolean[] added = new boolean[m];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                if (!added[row] && mat[row][col] == 0) {
                    ret[index++] = row;
                    added[row] = true;

                    if (index == k) {
                        return ret;
                    }
                }
            }
        }

        int i = 0;
        while (index < k) {
            if (!added[i]) {
                ret[index++] = i;
            }
            i++;
        }

        return ret;
    }

    public int[] kWeakestRows2(int[][] mat, int k) {
        if (mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length - 1;

        int[] s = new int[m];
        Integer[] t = new Integer[m];
        for (int i = 0; i < m; i++) {
            t[i] = i;
            int[] line = mat[i];

            int l = 0, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (line[mid] == 1) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            s[i] = (line[l] == 1 ? r + 1 : r);
        }

        Arrays.parallelSort(t, Comparator.comparingInt(a -> s[a]));

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = t[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int[] ans = new _1337_KWeakestRows().kWeakestRows(mat, 5);
        System.out.println(Arrays.toString(ans));
    }
}
