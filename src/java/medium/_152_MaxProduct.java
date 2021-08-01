package medium;

public class _152_MaxProduct {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, ans = nums[0];

        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(num * max, num);
            min = Math.min(num * min, num);

            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int max = 1, min = 1, ans = nums[0];

        for (int num : nums) {
            int mx = max, mn = min;
            max = Math.max(mx * num, Math.max(mn * num, num));
            min = Math.min(mn * num, Math.min(mx * num, num));

            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _152_MaxProduct().maxProduct2(new int[]{-2, 3, -4}));
        System.out.println(new _152_MaxProduct().maxProduct2(new int[]{-2}));
        System.out.println(new _152_MaxProduct().maxProduct2(new int[]{2, 3, -2, 4}));
        System.out.println(new _152_MaxProduct().maxProduct2(new int[]{-2, 0, -1}));
    }
}
