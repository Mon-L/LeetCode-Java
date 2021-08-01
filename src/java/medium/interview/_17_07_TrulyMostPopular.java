package medium.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/baby-names-lcci/
 */
public class _17_07_TrulyMostPopular {

    private Map<String, String> parents = new HashMap<>();

    /**
     * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"]
     * synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
     * 输出：["John(27)","Chris(36)"]
     *
     * @param names
     * @param synonyms
     * @return
     */
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        for (String synonym : synonyms) {
            int idx = synonym.indexOf(',');
            String name1 = synonym.substring(1, idx);
            String name2 = synonym.substring(idx + 1, synonym.length() - 1);
            union(name1, name2);
        }

        Map<String, Integer> mapping = new HashMap<>();
        for (String name : names) {
            int idx1 = name.indexOf('('), idx2 = name.indexOf(')');
            String n = name.substring(0, idx1);
            int num = Integer.parseInt(name.substring(idx1 + 1, idx2));

            String trulyName = find(n);
            mapping.put(trulyName, num + mapping.getOrDefault(trulyName, 0));

        }

        int index = 0;
        String[] ret = new String[mapping.size()];
        for (Map.Entry<String, Integer> entry : mapping.entrySet()) {
            ret[index++] = entry.getKey() + "(" + entry.getValue() + ")";
        }
        return ret;
    }

    private void union(String x, String y) {
        String rootX = find(x), rootY = find(y);

        if (rootX.equals(rootY)) return;

        if (rootX.compareTo(rootY) > 0) {
            parents.put(rootX, rootY);
        } else {
            parents.put(rootY, rootX);
        }
    }

    private String find(String x) {
        if (!parents.containsKey(x)) parents.put(x, x);

        if (!parents.get(x).equals(x)) {
            parents.put(x, find(parents.get(x)));
        }
        return parents.get(x);
    }

    public static void main(String[] args) {
        String[] names, synonyms;

        names = new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        synonyms = new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        System.out.println(Arrays.toString(new _17_07_TrulyMostPopular().trulyMostPopular(names, synonyms)));
    }
}
