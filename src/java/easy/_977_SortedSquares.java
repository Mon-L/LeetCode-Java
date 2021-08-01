package easy;

import java.util.Arrays;

public class _977_SortedSquares {
    public int[] sortedSquares(int[] A) {
        int start = 0, end = A.length - 1, index = end;
        int[] ans = new int[A.length];

        while (index >= 0) {
            ans[index] = Math.abs(A[start]) > Math.abs(A[end]) ? A[start] * A[start++] : A[end] * A[end--];
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _977_SortedSquares().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

}
