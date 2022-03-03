package easy;

public class _507_CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        int half = num / 2 ;

        for (int i = 1; i <= half; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return num == sum;
    }

    public static void main(String[] args) {
        System.out.println(new _507_CheckPerfectNumber().checkPerfectNumber(0));
        System.out.println(new _507_CheckPerfectNumber().checkPerfectNumber(28));
        System.out.println(new _507_CheckPerfectNumber().checkPerfectNumber(6));
        System.out.println(new _507_CheckPerfectNumber().checkPerfectNumber(496));
        System.out.println(new _507_CheckPerfectNumber().checkPerfectNumber(8128));
        System.out.println(new _507_CheckPerfectNumber().checkPerfectNumber(3));
    }
}
