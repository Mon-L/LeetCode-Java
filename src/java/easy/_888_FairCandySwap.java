package easy;

import java.util.Arrays;

public class _888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = 0;
        for (int a : A) {
            diff -= a;
        }

        boolean[] mapping = new boolean[100001];
        for (int b : B) {
            diff += b;
            mapping[b] = true;
        }

        diff /= 2;
        int na = 0, nb = 0;
        for (int a : A) {
            int t = a + diff;
            if (t >= 0 && t <= 100000 && mapping[t]) {
                na = a;
                nb = t;
                break;
            }
        }
        return new int[]{na, nb};
    }

    public static void main(String[] args) {
        int[] A, B;
        A = new int[]{1, 1};
        B = new int[]{2, 2};
        System.out.println(Arrays.toString(new _888_FairCandySwap().fairCandySwap(A, B)));  // 1, 2

        A = new int[]{2};
        B = new int[]{1, 3};
        System.out.println(Arrays.toString(new _888_FairCandySwap().fairCandySwap(A, B)));  // 2, 3

        A = new int[]{1, 2, 5};
        B = new int[]{2, 4};
        System.out.println(Arrays.toString(new _888_FairCandySwap().fairCandySwap(A, B))); // 5, 4

        A = new int[]{1, 17, 14, 1, 16};
        B = new int[]{26, 11};
        System.out.println(Arrays.toString(new _888_FairCandySwap().fairCandySwap(A, B))); // 17, 11
    }
}
