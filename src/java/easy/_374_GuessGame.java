package easy;

public class _374_GuessGame {

    public static int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int g = guess(mid);

            if (g == 0) {
                return mid;
            } else if (g == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     *
     * @param num
     * @return
     */
    public static int guess(int num) {
        return Integer.compare(1, num);
    }

    public static void main(String[] args) {
        System.out.println(_374_GuessGame.guessNumber(2));
    }
}
