package easy;

public class _231_IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(6 & -6);
        System.out.println(Integer.toBinaryString(6 & -6));
    }
}
