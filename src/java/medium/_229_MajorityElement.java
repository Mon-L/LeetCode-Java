package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _229_MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length / 3 + 1;
        List<Integer> ret = new LinkedList<>();

        Map<Integer, Integer> m = new HashMap<>();

        for (int a : nums) {
            Integer b = m.get(a);
            b = (b == null ? 1 : b + 1);

            if (b == n) {
                ret.add(a);
            }

            m.put(a, b);
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _229_MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new _229_MajorityElement().majorityElement(new int[]{1}));
        System.out.println(new _229_MajorityElement().majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));

    }
}
