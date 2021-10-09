package medium;

import java.util.Arrays;

public class _1109_CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ret = new int[n];

        for (int[] booking : bookings) {
            ret[booking[0] - 1] += booking[2];

            if (booking[1] < n) {
                ret[booking[1] - 1] -= booking[2];
            }
        }

        for (int i = 1; i < ret.length; i++) {
            ret[i] += ret[i - 1];
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] bookings = new int[][]{
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        System.out.println(Arrays.toString(new _1109_CorpFlightBookings().corpFlightBookings(bookings, 5))); //[10, 55, 45, 25, 25]

        bookings = new int[][]{
                {1, 2, 10},
                {2, 2, 15}
        };
        System.out.println(Arrays.toString(new _1109_CorpFlightBookings().corpFlightBookings(bookings, 2))); //[10, 25]
    }
}
