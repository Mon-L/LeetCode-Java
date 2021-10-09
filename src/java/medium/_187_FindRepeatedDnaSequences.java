package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _187_FindRepeatedDnaSequences {

    Map<Character, Integer> mapping = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length(), N = 10;
        Map<Integer, Integer> m = new HashMap<>();
        List<String> ret = new ArrayList<>();

        if (len <= 10) return ret;

        int key = 0, mask = (1 << N * 2) - 1;
        for (int i = 0; i < s.length(); i++) {
            key = (key << 2) | mapping.get(s.charAt(i));

            if (i >= N - 1) {
                key &= mask;
                int c = m.getOrDefault(key, 0);
                m.put(key, ++c);
                if (c == 2) {
                    ret.add(s.substring(i - N + 1, i + 1));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _187_FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(new _187_FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
