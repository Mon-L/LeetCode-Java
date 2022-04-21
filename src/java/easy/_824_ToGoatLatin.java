package easy;

public class _824_ToGoatLatin {

    public String toGoatLatin(String sentence) {
        StringBuilder ret = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");

        int i = 0, len = sentence.length();
        while (i < len) {
            char ch = sentence.charAt(i);

            int j = i;
            while (j < len && sentence.charAt(j) != ' ') {
                j++;
            }

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                ret.append(sentence, i, j).append("ma");
            } else {
                ret.append(sentence, i + 1, j).append(ch).append("ma");
            }

            ret.append(suffix);
            suffix.append('a');

            i = j + 1;
            if (i < len) {
                ret.append(" ");
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _824_ToGoatLatin().toGoatLatin("I speak Goat Latin"));
    }
}
