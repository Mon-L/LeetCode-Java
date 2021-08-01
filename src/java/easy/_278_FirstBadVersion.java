package easy;

public class _278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        return n >= 4;
    }

    public static void main(String[] args) {
        System.out.println(new _278_FirstBadVersion().firstBadVersion(5));
    }
}
