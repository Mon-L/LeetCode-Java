package easy.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 */
public class _59_1_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }

        ret[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            deque.add(nums[i]);

            ret[i - k + 1] = deque.peekFirst();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums, ret;

        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        ret = new _59_1_MaxSlidingWindow().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ret));

        nums = new int[]{1, 3, 1, 2, 0, 5};
        ret = new _59_1_MaxSlidingWindow().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ret));
    }
}
