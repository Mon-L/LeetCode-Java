package medium;

import java.util.ArrayList;
import java.util.List;

public class _1447_SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> ret = new ArrayList<>();

        if (n == 1) {
            return ret;
        }

        for (int i = 1; i < n; i++) { // 分子
            for (int j = i + 1; j <= n; j++) {  // 分母
                if (gcd(i, j) == 1) {
                    ret.add(i + "/" + j);
                }
            }
        }

        return ret;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new _1447_SimplifiedFractions().simplifiedFractions(1));
        System.out.println(new _1447_SimplifiedFractions().simplifiedFractions(2));
        System.out.println(new _1447_SimplifiedFractions().simplifiedFractions(3));
        System.out.println(new _1447_SimplifiedFractions().simplifiedFractions(4));
        System.out.println(new _1447_SimplifiedFractions().simplifiedFractions(5));
        System.out.println(new _1447_SimplifiedFractions().simplifiedFractions(6));
    }
}
