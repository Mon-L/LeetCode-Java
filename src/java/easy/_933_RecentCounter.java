package easy;

import java.util.LinkedList;
import java.util.Queue;

public class _933_RecentCounter {

    static class RecentCounter {

        private final Queue<Integer> queue;

        public RecentCounter() {
            this.queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);

            while (!queue.isEmpty() && t - queue.peek() > 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}
