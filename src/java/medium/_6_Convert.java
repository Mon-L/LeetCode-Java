package medium;

public class _6_Convert {

    /**
     * PAYPALISHIRING  numRow = 3
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * <p>
     * PAYPALISHIRING numRows = 4
     * P      I      N
     * A   L  S   I  G
     * Y A    H  R
     * P      I
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int n = s.length();
        int t = 2 * numRows - 2; // 一个周期多少个字符
        int cols = (n + t - 1) / t * (numRows - 1); // 一个周期占多少列
        
        char[][] mat = new char[numRows][cols];

        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            mat[a][b] = s.charAt(i);

            if (i % t < numRows - 1) {
                ++a; // 向下移动
            } else {
                --a;
                ++b; // 向右上移动
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != '\u0000') {
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _6_Convert().convert("A", 1));
        System.out.println(new _6_Convert().convert("ABC", 2));
        System.out.println(new _6_Convert().convert("PAYPALISHIRING", 3));
        System.out.println(new _6_Convert().convert("PAYPALISHIRING", 4));
    }
}
