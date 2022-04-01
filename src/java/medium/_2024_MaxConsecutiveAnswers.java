package medium;

public class _2024_MaxConsecutiveAnswers {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(doReplace(answerKey, 'T', k), doReplace(answerKey, 'F', k));
    }

    private int doReplace(String answerKey, char curr, int k) {
        int len = answerKey.length(), r = 0, l = 0, max = 0;
        while (r < len) {
            if (answerKey.charAt(r) != curr) {
                k--;
                while (k < 0) {
                    if (answerKey.charAt(l) != curr) {
                        k++;
                    }
                    l++;
                }
            }

            r++;
            max = Math.max(max, r - l);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _2024_MaxConsecutiveAnswers().maxConsecutiveAnswers("TTFF", 2));
        System.out.println(new _2024_MaxConsecutiveAnswers().maxConsecutiveAnswers("TFFT", 1));
        System.out.println(new _2024_MaxConsecutiveAnswers().maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(new _2024_MaxConsecutiveAnswers().maxConsecutiveAnswers("TTFTTTTTFT", 1));
    }
}
