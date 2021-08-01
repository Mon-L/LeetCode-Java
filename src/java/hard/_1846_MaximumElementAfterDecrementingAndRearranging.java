package hard;

import java.util.Arrays;

public class _1846_MaximumElementAfterDecrementingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int len = arr.length;
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _1846_MaximumElementAfterDecrementingAndRearranging().maximumElementAfterDecrementingAndRearranging(new int[]{91205}));
        System.out.println(new _1846_MaximumElementAfterDecrementingAndRearranging().maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        System.out.println(new _1846_MaximumElementAfterDecrementingAndRearranging().maximumElementAfterDecrementingAndRearranging(new int[]{73, 98, 9}));
        System.out.println(new _1846_MaximumElementAfterDecrementingAndRearranging().maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
        System.out.println(new _1846_MaximumElementAfterDecrementingAndRearranging().maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
    }
}
