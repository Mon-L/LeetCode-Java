package medium;

public class _38_CountAndSay {

    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder curr = new StringBuilder();

            int pos = 0;
            int start = 0;

            while (pos < pre.length()) {
                while (pos < pre.length() && pre.charAt(pos) == pre.charAt(start)) {
                    pos++;
                }
                curr.append(pos - start).append(pre.charAt(start));
                start = pos;
            }

            pre = curr.toString();
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new _38_CountAndSay().countAndSay(1));
        System.out.println(new _38_CountAndSay().countAndSay(2));
        System.out.println(new _38_CountAndSay().countAndSay(3));
        System.out.println(new _38_CountAndSay().countAndSay(4));
        System.out.println(new _38_CountAndSay().countAndSay(5));
        System.out.println(new _38_CountAndSay().countAndSay(7));
        System.out.println(new _38_CountAndSay().countAndSay(10));
        System.out.println(new _38_CountAndSay().countAndSay(11));
        System.out.println(new _38_CountAndSay().countAndSay(12));
    }
}
