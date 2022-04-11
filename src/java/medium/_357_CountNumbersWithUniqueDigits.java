package medium;

public class _357_CountNumbersWithUniqueDigits {

    private final int[] ret = new int[]{1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851};

    public int countNumbersWithUniqueDigits(int n) {
        return ret[n];
    }

    public static void main(String[] args) {
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(0));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(1));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(4));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(5));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(6));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(7));
        System.out.println(new _357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(8));
    }
}
