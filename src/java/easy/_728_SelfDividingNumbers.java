package easy;

import java.util.ArrayList;
import java.util.List;

public class _728_SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();

        while (left <= right) {
            if (isSelfDividingNumber(left)) {
                ret.add(left);
            }
            left++;
        }

        return ret;
    }

    private boolean isSelfDividingNumber(int num) {
        int t = num;
        while (t > 0) {
            int f = t % 10;
            if (f == 0 || num % f != 0) {
                return false;
            }
            t = t / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _728_SelfDividingNumbers().selfDividingNumbers(1, 22));
        System.out.println(new _728_SelfDividingNumbers().selfDividingNumbers(47, 85));
    }
}
