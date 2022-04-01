package medium;

import java.util.*;

public class _954_CanReorderDoubled {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<>(cnt.keySet());
        vals.sort(Comparator.comparingInt(Math::abs));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _954_CanReorderDoubled().canReorderDoubled(new int[]{-33, 0}));
        System.out.println(new _954_CanReorderDoubled().canReorderDoubled(new int[]{2, 4, 0, 0, 8, 1}));
        System.out.println(new _954_CanReorderDoubled().canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(new _954_CanReorderDoubled().canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(new _954_CanReorderDoubled().canReorderDoubled(new int[]{4, -2, 2, -4}));
    }
}
