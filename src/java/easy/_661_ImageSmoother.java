package easy;

import model.Utils;

public class _661_ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);

                int cnt = (c - a + 1) * (d - b + 1);
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ans[i][j] = tot / cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] img = new int[][]{
                {100, 200, 100}, {200, 50, 200}, {100, 200, 100}
        };

        System.out.println(Utils.twoDimensionalArray2String(new _661_ImageSmoother().imageSmoother(img)));
    }
}
