package hard;

//https://leetcode-cn.com/problems/trapping-rain-water/
public class TrappingRainWater {

    private static int trap(int[] height) {
        int sum = 0,
            left = 0,
            right = height.length - 1,
            left_max = 0,
            right_max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    sum += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    sum += right_max - height[right];
                }
                --right;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{2, 0, 2}));
    }

}
