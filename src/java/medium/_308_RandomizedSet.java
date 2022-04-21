package medium;

import java.util.*;

public class _308_RandomizedSet {

    private static class RandomizedSet {

        private Map<Integer, Integer> map = new HashMap<>();
        private List<Integer> list = new ArrayList<>();
        private Random random = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            //交换队尾元素到待删除元素的位置
            int idx = map.get(val);
            int lastIdx = list.size() - 1;

            int lastVal = list.get(lastIdx);
            list.set(idx, lastVal);
            map.put(lastVal, idx);

            map.remove(val);
            list.remove(lastIdx);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.remove(1);
        set.remove(2);
        set.insert(3);
        set.remove(3);
        boolean t = set.insert(3);

        System.out.println();
    }
}
