package easy;

public class _1128_NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] buckets = new int[100];
        for (int[] domino : dominoes) {
            int code = domino[0] <= domino[1]
                    ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];

            buckets[code]++;
        }

        int ret = 0;
        for (int n : buckets) {
            ret += n * (n - 1) / 2;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] dominoes = new int[][]{
                {1, 2}, {2, 1}, {3, 4}, {5, 6}, {1, 2}
        };

        System.out.println(new _1128_NumEquivDominoPairs().numEquivDominoPairs(dominoes));
    }
}
