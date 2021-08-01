package easy;

public class _392_IsSubsequence {
    //双指针
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length(), i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    //普通动态规划
    public boolean isSubsequence2(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

                if (i == s.length() && dp[i][j] == 1) {
                    return true;
                }
            }
        }
        return dp[s.length()][t.length()] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new _392_IsSubsequence().isSubsequence("agd", "ahbgdc"));
    }
}
