package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _846_IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) return true;
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> hand2Num = new HashMap<>();
        for (int h : hand) {
            Integer n = hand2Num.get(h);
            hand2Num.put(h, n == null ? 1 : n + 1);
        }

        for (int h : hand) {
            if (hand2Num.get(h) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    Integer num = hand2Num.get(h + i);
                    if (num == null || num == 0) {
                        return false;
                    }
                    hand2Num.put(h + i, num - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _846_IsNStraightHand().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(new _846_IsNStraightHand().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
