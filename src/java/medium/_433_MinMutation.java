package medium;

import java.util.*;

public class _433_MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = new HashSet<>();
        Collections.addAll(banks, bank);

        Queue<String> deque = new LinkedList<>();
        deque.add(start);

        int count = 0;
        while (!deque.isEmpty()) {
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String head = deque.poll();

                Set<String> needRemoved = new HashSet<>();
                for (String b : banks) {
                    int diff = 0;
                    for (int j = 0; j < head.length(); j++) {
                        if (head.charAt(j) != b.charAt(j)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        if (b.equals(end)) return count;
                        deque.add(b);
                        needRemoved.add(b);
                    }
                }
                banks.removeAll(needRemoved);
            }
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

        /**
         * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
         * 输出：2
         */
        start = "AACCGGTT";
        end = "AAACGGTA";
        bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(new _433_MinMutation().minMutation(start, end, bank));

        /**
         * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
         * 输出：3
         *
         */
        start = "AAAAACCC";
        end = "AACCCCCC";
        bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(new _433_MinMutation().minMutation(start, end, bank));
    }
}
