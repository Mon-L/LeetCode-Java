package easy;

import java.util.ArrayList;
import java.util.List;

public class _118_Generate {

    /**
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                row.add(dp[i][j]);
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _118_Generate().generate(5));
    }
}
