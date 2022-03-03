package easy;

public class _121_MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            maxProfit = Math.max(maxProfit, price - min);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new _121_MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new _121_MaxProfit().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
