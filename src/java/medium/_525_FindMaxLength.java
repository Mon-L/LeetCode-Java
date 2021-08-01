package medium;

import java.util.Arrays;

public class _525_FindMaxLength {
    public static int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] sums = new int[nums.length * 2 + 1];
        Arrays.fill(sums, -1);

        int counter = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += nums[i] == 0 ? 1 : -1;

            if (counter == 0) {
                maxLength = i + 1;
            } else if (sums[counter + len] != -1) {
                maxLength = Math.max(i - sums[counter + len], maxLength);
            } else {
                sums[counter + len] = i;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(_525_FindMaxLength.findMaxLength(new int[]{0, 1}));
        System.out.println(_525_FindMaxLength.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(_525_FindMaxLength.findMaxLength(new int[]{0, 1, 1, 1, 0, 0, 0, 0}));
    }
}
