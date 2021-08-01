package easy;

public class _860_LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int b5 = 0, b10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                b5++;
            } else if (bill == 10) {
                b10++;
                b5--;
            } else if (b10 > 0) {
                b10--;
                b5--;
            } else {
                b5 -= 3;
            }

            if (b5 < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _860_LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(new _860_LemonadeChange().lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(new _860_LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(new _860_LemonadeChange().lemonadeChange(new int[]{5, 5, 20, 5, 5, 10, 5, 10, 5, 20}));
    }
}
