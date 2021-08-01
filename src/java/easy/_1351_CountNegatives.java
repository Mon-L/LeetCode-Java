package easy;

public class _1351_CountNegatives {
    public int countNegatives(int[][] grid) {
        int row = grid.length - 1, col = grid[0].length;

        int count = 0, j = 0;
        while (row >= 0 && j < col) {
            if (grid[row][j] < 0) {
                count += (col - j);
                row--;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(new _1351_CountNegatives().countNegatives(grid));

        grid = new int[][]{
                {3, 2},
                {1, 0}
        };
        System.out.println(new _1351_CountNegatives().countNegatives(grid));

        grid = new int[][]{
                {-1}
        };
        System.out.println(new _1351_CountNegatives().countNegatives(grid));
    }
}
