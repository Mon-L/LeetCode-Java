package medium;

public class _474_FindMaxForm {

    //m --> 0
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {

            int zeros = 0, ones = 0;
            for (char ch : strs[i - 1].toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
//        String[] strs;
//
//        strs = new String[]{"10", "0001", "111001", "1", "0"};
//        System.out.println(_474_FindMaxForm.findMaxForm(strs, 5, 3));

        System.out.println(_474_FindMaxForm.class.getName());
        System.out.println(_474_FindMaxForm.class.getCanonicalName());
        System.out.println(_474_FindMaxForm.class.getSimpleName());
    }
}
