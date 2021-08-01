package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        if (nums.length * k == 0) return new int[0];

        int len = nums.length;
        int[] output = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                deque.pop();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                output[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
