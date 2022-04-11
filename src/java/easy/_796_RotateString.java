package easy;

public class _796_RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) != goal.charAt((i + j) % n)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _796_RotateString().rotateString("abcde", "cdeab"));
        System.out.println(new _796_RotateString().rotateString("abcde", "abced"));
    }
}
