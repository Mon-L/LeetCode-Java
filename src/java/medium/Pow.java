package medium;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * Pow(x, n)
 */
public class Pow {
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        double r;
        r = new Pow().myPow(2, 8);
        r = new Pow().myPow(2, -2147483648);
        System.out.println(r);
    }
}
