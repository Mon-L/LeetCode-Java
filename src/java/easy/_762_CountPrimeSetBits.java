package easy;

public class _762_CountPrimeSetBits {
    static boolean[] hash = new boolean[40];

    static {
        int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int x : nums) hash[x] = true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while (left <= right) {
            int bit = Integer.bitCount(left++);

            if (hash[bit]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _762_CountPrimeSetBits().countPrimeSetBits(6, 10));
        System.out.println(new _762_CountPrimeSetBits().countPrimeSetBits(10, 15));
    }
}
