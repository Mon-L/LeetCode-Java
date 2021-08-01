package medium;

public class _342_IsPowerOfFour {
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & -n) == n && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(_342_IsPowerOfFour.isPowerOfFour(0));
        System.out.println(_342_IsPowerOfFour.isPowerOfFour(16));
        System.out.println(_342_IsPowerOfFour.isPowerOfFour(5));
        System.out.println(_342_IsPowerOfFour.isPowerOfFour(1));
        System.out.println(_342_IsPowerOfFour.isPowerOfFour(8));
    }
}
