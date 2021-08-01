package easy;

public class _367_IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long t = (long) mid * mid;
            if (t == num) {
                return true;
            } else if (t < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _367_IsPerfectSquare().isPerfectSquare(1));
    }
}
