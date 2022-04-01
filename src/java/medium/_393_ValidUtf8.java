package medium;

public class _393_ValidUtf8 {
    /**
     * Char. number range  |        UTF-8 octet sequence
     * (hexadecimal)    |              (binary)
     * --------------------+---------------------------------------------
     * 0000 0000-0000 007F | 0xxxxxxx
     * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     *
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        int dataIndex = 0;
        for (int d : data) {
            if (dataIndex == 0) {
                if ((d >> 5) == 0b110) dataIndex = 1;
                else if ((d >> 4) == 0b1110) dataIndex = 2;
                else if ((d >> 3) == 0b11110) dataIndex = 3;
                else if (d >> 7 != 0) return false;
            } else {
                if ((d >> 6) != 0b10) return false;
                --dataIndex;
            }
        }
        return dataIndex == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _393_ValidUtf8().validUtf8(new int[]{237}));
        System.out.println(new _393_ValidUtf8().validUtf8(new int[]{145}));
        System.out.println(new _393_ValidUtf8().validUtf8(new int[]{197, 130, 1}));
        System.out.println(new _393_ValidUtf8().validUtf8(new int[]{235, 140, 4}));
        System.out.println(new _393_ValidUtf8().validUtf8(new int[]{248, 130, 130, 130}));
    }
}
