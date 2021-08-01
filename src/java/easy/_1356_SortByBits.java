package easy;

import java.util.Arrays;

public class _1356_SortByBits {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 100000;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ans = new _1356_SortByBits().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(Arrays.toString(ans));
    }
}
