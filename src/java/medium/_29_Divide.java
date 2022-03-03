package medium;

public class _29_Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return dividend;
            if (divisor == -1) return Integer.MAX_VALUE;
        }

        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean negative = (dividend ^ divisor) < 0;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long l = 0, r = a;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mul(b, mid) <= a) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return (int) (negative ? -r : r);
    }

    private long mul(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) ans += a;
            b >>= 1;
            a += a;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _29_Divide().divide(1, 1));
        System.out.println(new _29_Divide().divide(10, 3));
        System.out.println(new _29_Divide().divide(0, 3));
        System.out.println(new _29_Divide().divide(7, -3));
        System.out.println(new _29_Divide().divide(-7, -3));
        System.out.println(new _29_Divide().divide(-2147483648, -1));
        System.out.println(new _29_Divide().divide(2147483647, 1));
    }
}
