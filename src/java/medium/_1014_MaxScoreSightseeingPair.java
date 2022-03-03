package medium;

public class _1014_MaxScoreSightseeingPair {

    /**
     * 输入：values = [8,1,5,2,6]
     * 输出：11
     * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
     */
    public int maxScoreSightseeingPair(int[] values) {
        int ret = 0, max = values[0];
        for (int i = 1; i < values.length; ++i) {
            ret = Math.max(ret, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _1014_MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(new _1014_MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{1, 2}));
    }
}
