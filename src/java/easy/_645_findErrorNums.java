package easy;

import java.util.Arrays;

public class _645_findErrorNums {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length + 1;
        int[] ret = new int[2];
        int[] m = new int[len];

        for (int i : nums) m[i]++;

        for (int i = 1; i < len; i++) {
            if (m[i] == 0) ret[1] = i;
            else if (m[i] > 1) ret[0] = i;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _645_findErrorNums().findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(new _645_findErrorNums().findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(new _645_findErrorNums().findErrorNums(new int[]{2, 2})));
        System.out.println(Arrays.toString(new _645_findErrorNums().findErrorNums(new int[]{2, 2})));
    }
}
