package easy;

public class _258_AddDigits {

    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new _258_AddDigits().addDigits(0));
        System.out.println(new _258_AddDigits().addDigits(2));
        System.out.println(new _258_AddDigits().addDigits(10));
        System.out.println(new _258_AddDigits().addDigits(38));
    }
}
