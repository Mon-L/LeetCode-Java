package hard;

import java.util.Stack;

public class LargestRectangleInHistogram {

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> minStack = new Stack<>();
        minStack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (minStack.peek() != -1 && heights[minStack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[minStack.pop()] * (i - minStack.peek() - 1));
            }
            minStack.push(i);
        }

        while (minStack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[minStack.pop()] * (heights.length - minStack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1}));
        System.out.println(largestRectangleArea(new int[]{1, 1}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
