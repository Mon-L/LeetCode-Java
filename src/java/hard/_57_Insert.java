package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class _57_Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(a -> a[0]))
                .collect(Collectors.toList());

        int[][] arr = list.toArray(new int[0][0]);

        return null;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {6, 9}
        };

        new _57_Insert().insert(intervals, new int[0]);
    }
}
