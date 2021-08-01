package medium;

public class _495_FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0, end = -1;
        for (int t : timeSeries) {
            if (end >= t) {
                int n = end;
                end = t + duration - 1;
                sum += (end - n);
            } else {
                end = t + duration - 1;
                sum += duration;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] timeSeries;

        timeSeries = new int[]{1, 4};  // 4
        System.out.println(new _495_FindPoisonedDuration().findPoisonedDuration(timeSeries, 2));

        timeSeries = new int[]{1, 2}; // 3
        System.out.println(new _495_FindPoisonedDuration().findPoisonedDuration(timeSeries, 2));

        timeSeries = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}; // 9
        System.out.println(new _495_FindPoisonedDuration().findPoisonedDuration(timeSeries, 1));

        timeSeries = new int[]{1, 2, 3, 4, 5}; // 9
        System.out.println(new _495_FindPoisonedDuration().findPoisonedDuration(timeSeries, 5));
    }
}
