package medium;

import java.util.*;

public class _752_OpenLock {
    private Set<String> deadSet;

    public int openLock(String[] deadends, String target) {
        String start = "0000";

        if (start.equals(target)) return 0;

        deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(start)) return -1;

        Queue<String> q1 = new LinkedList<>();
        Map<String, Integer> m1 = new HashMap<>();
        q1.add(start);
        m1.put(start, 0);

        Queue<String> q2 = new LinkedList<>();
        Map<String, Integer> m2 = new HashMap<>();
        q2.add(target);
        m2.put(target, 0);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int ret = -1;
            if (q1.size() <= q2.size()) {
                ret = update(q1, m1, m2);
            } else {
                ret = update(q2, m2, m1);
            }

            if (ret != -1) return ret;
        }

        return -1;
    }

    public int update(Queue<String> queue, Map<String, Integer> mapping, Map<String, Integer> otherMapping) {
        String curr = queue.poll();
        int step = mapping.get(curr);

        for (String next : search(curr)) {
            if (deadSet.contains(next) || mapping.containsKey(next)) {
                continue;
            }

            if (otherMapping.containsKey(next)) {
                return otherMapping.get(next) + step + 1;
            } else {
                queue.offer(next);
                mapping.put(next, step + 1);
            }
        }

        return -1;
    }

    public List<String> search(String curr) {
        List<String> ret = new ArrayList<>(4);
        char[] chars = curr.toCharArray();

        for (int i = 0; i < 4; i++) {
            char c = chars[i];

            //next
            chars[i] = (c == '9' ? '0' : (char) (c + 1));
            ret.add(new String(chars));

            //prev
            chars[i] = (c == '0' ? '9' : (char) (c - 1));
            ret.add(new String(chars));

            chars[i] = c;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _752_OpenLock().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(new _752_OpenLock().openLock(new String[]{"8888"}, "0009"));
    }
}
