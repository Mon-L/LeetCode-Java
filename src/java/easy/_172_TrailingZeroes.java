package easy;

public class _172_TrailingZeroes {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _172_TrailingZeroes().trailingZeroes(3));
    }
}
