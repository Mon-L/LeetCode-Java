package medium;

public class _1035_MaxUncrossedLines {

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length + 1;
        int n = nums2.length + 1;

        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }

}
