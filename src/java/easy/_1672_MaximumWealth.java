package easy;

public class _1672_MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] row : accounts) {
            int k = 0;
            for (int i : row) {
                k += i;
            }

            if (k > max) {
                max = k;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _1672_MaximumWealth().maximumWealth(new int[][]{
                {1, 2, 3}, {3, 2, 1}
        }));
    }
}
