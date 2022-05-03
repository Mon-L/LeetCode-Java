package easy;

public class _868_BinaryGap {
    public int binaryGap(int n) {
        String str = Integer.toBinaryString(n);
        char[] chs = str.toCharArray();
        int pre = 0, index = 0, ret = 0;

        while (index < chs.length) {
            if (chs[index] == '1') {
                ret = Math.max(ret, index - pre);
                pre = index;
            }
            index++;
        }

        return ret;
    }

    public int binaryGap2(int n) {
        int pre = -1, ret = 0;
        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    ret = Math.max(ret, i - pre);
                }
                pre = i;
            }
            n = n >> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _868_BinaryGap().binaryGap2(22));
        System.out.println(new _868_BinaryGap().binaryGap2(8));
        System.out.println(new _868_BinaryGap().binaryGap2(5));
    }
}
