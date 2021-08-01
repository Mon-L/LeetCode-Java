package medium;

public class _477_TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length, ret = 0;
        for (int i = 0; i < 30; i++) {
            int n = 0;
            for (int j = 0; j < len; j++) {
                n += (nums[j] >> i) & 1;
            }
            ret += n * (len - n);
        }
        return ret;
    }

    private int distance(int i, int j) {
        return Integer.bitCount(i ^ j);
    }

    public static void main(String[] args) {
        System.out.println(new _477_TotalHammingDistance().totalHammingDistance(new int[]{4, 14, 2}));
    }
}
