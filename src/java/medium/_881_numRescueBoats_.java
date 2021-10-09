package medium;

import java.util.Arrays;

public class _881_numRescueBoats_ {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, num = 0;

        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }

            num++;
            right--;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new _881_numRescueBoats_().numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(new _881_numRescueBoats_().numRescueBoats(new int[]{2, 4}, 5));
        System.out.println(new _881_numRescueBoats_().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(new _881_numRescueBoats_().numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
