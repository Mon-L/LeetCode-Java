package easy;

import java.util.HashMap;
import java.util.Map;

public class _290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] patterns = pattern.toCharArray();
        String[] fragments = s.split(" ");

        if (patterns.length != fragments.length) {
            return false;
        }

        Map<Character, String> mapping = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            String f = mapping.get(patterns[i]);
            if (f == null) {
                if (mapping.containsValue(fragments[i])) {
                    return false;
                }
                mapping.put(patterns[i], fragments[i]);
            } else if (!f.equals(fragments[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _290_WordPattern().wordPattern("abba", "dog dog dog dog"));
        System.out.println(new _290_WordPattern().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new _290_WordPattern().wordPattern("abba", "dog cat cat fish"));
    }
}
