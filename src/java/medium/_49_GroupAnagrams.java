package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class _49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> mapping = new HashMap<>();

        for (String str : strs) {
            long key = getHash(str);
            if (mapping.containsKey(key)) {
                mapping.get(key).add(str);
            } else {
                mapping.put(key, new ArrayList<String>() {{
                    add(str);
                }});
            }
        }

        return new ArrayList<>(mapping.values());
    }

    private long getHash(String strs) {
        long hash;
        long sum = 0;
        long prod = 1;
        for (char c : strs.toCharArray()) {
            sum += (c);
            prod *= (c);
        }
        hash = sum + prod;
        return hash;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = new _49_GroupAnagrams().groupAnagrams(strs);
        System.out.println(ans);
    }
}
