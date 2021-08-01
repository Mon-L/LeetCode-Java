package hard;

public class _65_IsNumber {

    public static boolean isNumber(String s) {
        int dot = 1, e = 1, num = 0, len = s.length();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-' || ch == '+') {
                if (i > 0) {
                    char pre = s.charAt(i - 1);
                    if (pre != 'e' && pre != 'E') {
                        return false;
                    }
                }

                if(i == len - 1){
                    return false;
                }
            } else if (ch == '.') {
                if (len == 1 || dot-- <= 0) {
                    return false;
                }
            } else if (ch == 'e' || ch == 'E') {
                if (i == 0 || i == len - 1 || e-- <= 0) {
                    return false;
                }

                char pre = s.charAt(i - 1);
                if (pre < '0' || pre > '9') {
                    return false;
                }

                dot--;
            } else if (ch < '0' || ch > '9') {
                return false;
            }else{
                num ++;
            }
        }
        return num > 0;
    }

    public static void main(String[] args) {
        System.out.println(_65_IsNumber.isNumber("2"));
        System.out.println(_65_IsNumber.isNumber("0089"));
        System.out.println(_65_IsNumber.isNumber("-0.1"));
        System.out.println(_65_IsNumber.isNumber("+3.14"));
        System.out.println(_65_IsNumber.isNumber("4."));
        System.out.println(_65_IsNumber.isNumber(".1"));
        System.out.println(_65_IsNumber.isNumber("-.9"));
        System.out.println(_65_IsNumber.isNumber("+6e-1"));

        System.out.println(_65_IsNumber.isNumber("--6"));
        System.out.println(_65_IsNumber.isNumber("99e2.5"));
        System.out.println(_65_IsNumber.isNumber("95a54e53"));
        System.out.println(_65_IsNumber.isNumber("1e"));
        System.out.println(_65_IsNumber.isNumber(".e1"));
        System.out.println(_65_IsNumber.isNumber("."));
        System.out.println(_65_IsNumber.isNumber("4e+"));
    }
}
