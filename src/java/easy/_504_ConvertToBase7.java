package easy;

public class _504_ConvertToBase7 {

    public String convertToBase7(int num) {
        boolean isNegative = false;

        if (num >= 0) {
            if (num <= 6) {
                return num + "";
            }
        } else {
            num = -num;
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }

        if (isNegative) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _504_ConvertToBase7().convertToBase7(0));
        System.out.println(new _504_ConvertToBase7().convertToBase7(1));
        System.out.println(new _504_ConvertToBase7().convertToBase7(7));
        System.out.println(new _504_ConvertToBase7().convertToBase7(8));
        System.out.println(new _504_ConvertToBase7().convertToBase7(100));
        System.out.println(new _504_ConvertToBase7().convertToBase7(-7));
    }
}
