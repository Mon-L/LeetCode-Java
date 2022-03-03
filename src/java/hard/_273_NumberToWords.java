package hard;

public class _273_NumberToWords {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder ret = new StringBuilder();

        for (int i = 3, unit = 1000000000; i > 0; i--, unit /= 1000) {
            int j = num / unit;

            if (j != 0) {
                num = num - j * unit;

                toEn(ret, j);
                ret.append(thousands[i]).append(" ");
            }
        }

        return ret.toString().trim();
    }

    private void toEn(StringBuilder sb, int num) {
        if (num == 0) return;

        if (num < 10) {
            sb.append(singles[num]).append(" ");
        } else if (num < 20) {
            sb.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            sb.append(tens[num / 10]).append(" ");
            toEn(sb, num % 10);
        } else {
            sb.append(singles[num / 100]).append(" Hundred ");
            toEn(sb, num % 100);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _273_NumberToWords().numberToWords(1234567891));
    }
}
