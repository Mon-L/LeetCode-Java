package medium;

import java.util.HashMap;
import java.util.Map;

public class _1218_LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> num2count = new HashMap<>();

        for (int num : arr) {
            int count = num2count.getOrDefault(num - difference, 0);
            count++;

            num2count.put(num, count);
            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _1218_LongestSubsequence().longestSubsequence(new int[]{1, 2, 3, 4}, 1));  //4
        System.out.println(new _1218_LongestSubsequence().longestSubsequence(new int[]{1, 3, 5, 7}, 1));  //1
        System.out.println(new _1218_LongestSubsequence().longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));  //4
    }
}
