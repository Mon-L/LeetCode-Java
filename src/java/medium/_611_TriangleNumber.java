package medium;

import java.util.Arrays;

public class _611_TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            int l = 0, r = i - 1;

            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _611_TriangleNumber().triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(new _611_TriangleNumber().triangleNumber(new int[]{4, 2, 3, 4}));
        System.out.println(new _611_TriangleNumber().triangleNumber(new int[]{7, 0, 0, 0}));
    }
}
