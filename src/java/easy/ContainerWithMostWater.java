package easy;

class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0, j = heights.length - 1; i < j; ) {
            int minHeight = heights[i] < heights[j] ? heights[i++] : heights[j--];
            int area = minHeight * (j - i + 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
