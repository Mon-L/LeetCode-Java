package hard;

import java.util.*;

public class _1606_BusiestServers {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        int max = Integer.MIN_VALUE;
        int[] worked = new int[k];
        List<Integer> ret = new ArrayList<>();

        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            Integer pos = available.ceiling(i % k);
            if (pos == null) {
                pos = available.first();
            }

            worked[pos]++;
            busy.offer(new int[]{arrival[i] + load[i], pos});
            available.remove(pos);

            if (worked[pos] > max) {
                max = worked[pos];
            }
        }

        for (int i = 0; i < worked.length; i++) {
            if (worked[i] == max) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _1606_BusiestServers().busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
        System.out.println(new _1606_BusiestServers().busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2}));
        System.out.println(new _1606_BusiestServers().busiestServers(7, new int[]{1, 3, 4, 5, 6, 11, 12, 13, 15, 19, 20, 21, 23, 25, 31, 32}, new int[]{9, 16, 14, 1, 5, 15, 6, 10, 1, 1, 7, 5, 11, 4, 4, 6}));
    }
}
