package easy;

public class _69_MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x / 2 + 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ( (long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _69_MySqrt().mySqrt(5));
        System.out.println(new _69_MySqrt().mySqrt(81));
        System.out.println(new _69_MySqrt().mySqrt(2147395599));
    }
}
