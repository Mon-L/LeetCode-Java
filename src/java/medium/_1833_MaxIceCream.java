package medium;

import java.util.Arrays;

public class _1833_MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int i = 0, myConst = coins;
        while (myConst > 0 && i < costs.length) {
            myConst -= costs[i++];
        }

        return myConst < 0 ? i - 1 : i;
    }

    public int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) freq[cost]++;

        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins < i) break;
            if (freq[i] == 0) continue;

            int curCount = Math.min(freq[i], coins / i);
            count += curCount;
            coins -= i * curCount;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _1833_MaxIceCream().maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(new _1833_MaxIceCream().maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(new _1833_MaxIceCream().maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }
}
