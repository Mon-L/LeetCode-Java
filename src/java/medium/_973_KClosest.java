package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class _973_KClosest {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(pointA -> pointA[0]));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            queue.offer(new int[]{point[0] * point[0] + point[1] * point[1], i});
        }

        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[queue.poll()[1]];
        }
        return ans;
    }

    private Random rand = new Random();

    public int[][] kClosest2(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    private void swap(int[][] points, int a, int b) {
        int[] temp = points[b];
        points[b] = points[a];
        points[a] = temp;
    }

    public static void main(String[] args) {
        int[][] ans = new _973_KClosest().kClosest2(new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        }, 2);


        for (int[] point : ans) {
            System.out.print(Arrays.toString(point) + " ");
        }
    }
}
