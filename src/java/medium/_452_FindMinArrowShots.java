package medium;

import java.util.Arrays;

/**
 * [[1,2],[3,7],[3,4],[4,5]]
 */
public class _452_FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }

        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points;

        points = new int[][]{
                {3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}
        };
        System.out.println(new _452_FindMinArrowShots().findMinArrowShots(points));

        points = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        System.out.println(new _452_FindMinArrowShots().findMinArrowShots(points));

        points = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        System.out.println(new _452_FindMinArrowShots().findMinArrowShots(points));

        points = new int[][]{
                {-2147483646, -2147483645}, {2147483646, 2147483647}
        };
        System.out.println(new _452_FindMinArrowShots().findMinArrowShots(points));
    }
}
