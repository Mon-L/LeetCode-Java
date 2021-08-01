package medium;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class _347_TopKFrequent {

    //------------堆--------------//
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return new int[0];

        Map<Integer, Integer> mapping = new HashMap<>();
        for (int num : nums) {
            mapping.put(num, mapping.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(mapping::get));

        for (Integer key : mapping.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (mapping.get(key) > mapping.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        int[] ans = new int[k];
        for (int i = 0, len = queue.size(); i < len; i++) {
            ans[i] = queue.remove();
        }
        return ans;
    }
    //------------堆--------------//

    //------------快排-----------//
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
    //------------快排-----------//

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _347_TopKFrequent().topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
