package medium;

import java.util.HashMap;
import java.util.Map;

public class _2013_DetectSquares {

    private class DetectSquares {

        private final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            int x = point[0], y = point[1];
            map.putIfAbsent(x, new HashMap<>());
            Map<Integer, Integer> yMap = map.get(x);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        public int count(int[] point) {
            int x = point[0], y = point[1];

            if (!map.containsKey(x)) {
                return 0;
            }

            int ans = 0;
            Map<Integer, Integer> yMap = map.get(x);

            for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
                int x1 = entry.getKey();

                if (x1 != x) {
                    int d = x1 - x;
                    Map<Integer, Integer> y1Map = entry.getValue();

                    ans += y1Map.getOrDefault(y, 0) * y1Map.getOrDefault(y + d, 0) * yMap.getOrDefault(y + d, 0);
                    ans += y1Map.getOrDefault(y, 0) * y1Map.getOrDefault(y - d, 0) * yMap.getOrDefault(y - d, 0);
                }
            }

            return ans;
        }

    }
}
