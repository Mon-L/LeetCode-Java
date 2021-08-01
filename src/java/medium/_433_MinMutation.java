package medium;

import java.util.*;

public class _433_MinMutation {

    private final char[] directions = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) return -1;

        Set<String> notUsed = new HashSet<>(Arrays.asList(bank));
        notUsed.add(start);

        int count = 0;
        Deque<String> deque = new LinkedList<>();

        deque.add(start);
        notUsed.remove(start);

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String curr = deque.pollFirst();
                char[] chars = curr.toCharArray();

                if (curr.equals(end)) {
                    return count;
                }

                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];

                    for (char direction : directions) {
                        if (old == direction) {
                            continue;
                        }
                        chars[i] = direction;
                        String temp = new String(chars);
                        if (notUsed.contains(temp)) {
                            deque.addLast(temp);
                            notUsed.remove(temp);
                        }
                        chars[i] = old;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        /**
         * "AACCGGTT"
         * "AACCGGTA"
         * ["AACCGGTA"]
         */
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA"};
        System.out.println(new _433_MinMutation().minMutation(start, end, bank));
    }
}
