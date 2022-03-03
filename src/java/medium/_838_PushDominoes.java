package medium;

public class _838_PushDominoes {

    /**
     * 输入：dominoes = ".L.R...LR..L.."
     * 输出："LL.RR.LLRRLL.."
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        char[] chs = dominoes.toCharArray();

        int i = 0, n = chs.length;
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && chs[j] == '.') {
                j++;
            }

            char right = j < n ? chs[j] : 'R';
            if (left == right) {
                while (i < j) {
                    chs[i++] = right;
                }
            } else if (right == 'L' && left == 'R') {
                int k = j - 1;
                while (i < k) {
                    chs[k--] = 'L';
                    chs[i++] = 'R';
                }
            }

            left = right;
            i = j + 1;
        }

        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(new _838_PushDominoes().pushDominoes(".L.R...LR..L.."));
    }
}
