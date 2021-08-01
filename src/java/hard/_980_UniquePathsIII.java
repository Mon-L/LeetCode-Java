package hard;

public class _980_UniquePathsIII {

    private int ans;
    private int row;
    private int col;
    private final int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;

        int shouldVisit = 0;
        int a = 0, b = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] != -1) {
                    shouldVisit++;
                }

                if (grid[i][j] == 1) {
                    a = i;
                    b = j;
                }
            }
        }

        backtrack(grid, a, b, shouldVisit);
        return ans;
    }

    private void backtrack(int[][] grid, int x, int y, int shouldVisit) {
        shouldVisit--;
        if (grid[x][y] == 2) {
            if (shouldVisit == 0) {
                ans++;
            }
            return;
        }

        grid[x][y] = 3;

        for (int[] d : direction) {
            int x1 = x + d[0];
            int y1 = y + d[1];
            if (inArea(x1, y1)) {
                int type = grid[x1][y1];
                if (type != 3 && type != -1 && type != 1) {
                    backtrack(grid, x1, y1, shouldVisit);
                    grid[x1][y1] = type;
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };

        System.out.println(new _980_UniquePathsIII().uniquePathsIII(grid));
    }
}
