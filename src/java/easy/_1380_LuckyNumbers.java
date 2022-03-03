package easy;

import java.util.ArrayList;
import java.util.List;

public class _1380_LuckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ret = new ArrayList<>();

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < matrix[i][rows[i]]) {
                    rows[i] = j;
                }

                if (matrix[i][j] > matrix[cols[j]][j]) {
                    cols[j] = i;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (i == cols[rows[i]]) {
                ret.add(matrix[i][rows[i]]);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };

        System.out.println(new _1380_LuckyNumbers().luckyNumbers(matrix));

        matrix = new int[][]{
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}
        };

        System.out.println(new _1380_LuckyNumbers().luckyNumbers(matrix));

        matrix = new int[][]{
                {7, 8},
                {1, 2},
        };

        System.out.println(new _1380_LuckyNumbers().luckyNumbers(matrix));
    }
}
