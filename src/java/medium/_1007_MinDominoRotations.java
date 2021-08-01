package medium;

public class _1007_MinDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int[] aCount = new int[7];
        int[] bCount = new int[7];
        int[] cCount = new int[7];
        for (int i : A) {
            aCount[i]++;
            cCount[i]++;
        }

        for (int i = 0; i < B.length; i++) {
            if (A[i] != B[i]) {
                cCount[B[i]]++;
            }
            bCount[B[i]]++;
        }

        for (int i = 1; i < cCount.length; i++) {
            if (cCount[i] == A.length) {
                return A.length - Math.max(aCount[i], bCount[i]);
            }
        }

        return -1;
    }

    public int minDominoRotations2(int[] A, int[] B) {
        int ret = check(A, B, A[0], A.length);
        return ret != -1 || A[0] == B[0] ? ret : check(B, A, B[0], A.length);
    }

    public int check(int[] A, int[] B, int target, int len) {
        int rA = 0, rB = 0;

        for (int i = 0; i < len; i++) {
            if (A[i] != target && B[i] != target) return -1;
            else if (A[i] != target) rA++;
            else if (B[i] != target) rB++;
        }

        return Math.min(rA, rB);
    }

    public static void main(String[] args) {
        int[] a, b;
        a = new int[]{2, 1, 2, 4, 2, 2};
        b = new int[]{5, 2, 6, 2, 3, 2};
        System.out.println(new _1007_MinDominoRotations().minDominoRotations2(a, b));

        a = new int[]{3, 5, 1, 2, 3};
        b = new int[]{3, 6, 3, 3, 4};
        System.out.println(new _1007_MinDominoRotations().minDominoRotations2(a, b));

        a = new int[]{1, 2, 3, 4, 6};
        b = new int[]{6, 6, 6, 6, 5};
        System.out.println(new _1007_MinDominoRotations().minDominoRotations2(a, b));

        a = new int[]{1, 2, 1, 1, 1, 2, 2, 2};
        b = new int[]{2, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(new _1007_MinDominoRotations().minDominoRotations2(a, b));
    }
}
