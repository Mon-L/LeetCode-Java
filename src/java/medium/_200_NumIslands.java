package medium;

import java.util.Deque;
import java.util.LinkedList;

public class _200_NumIslands {

    private int m;
    private int n;
    private final int[] dx = new int[]{0, 0, 1, -1};
    private final int[] dy = new int[]{1, -1, 0, 0};

    //--------------dfs------------//
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;

        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (!inArea(row, col) || grid[row][col] == '0') return;

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
    //--------------dfs------------//

    //--------------循环版dfs------------//
    public int numIslands2(char[][] grid) {
        if (grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;

        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;

                    Deque<Integer> deque = new LinkedList<>();
                    deque.add(i * n + j);

                    while (!deque.isEmpty()) {
                        int cell = deque.poll();
                        int r = cell / n;
                        int c = cell % n;

                        for (int k = 0; k < 4; k++) {
                            int a = r + dx[k], b = c + dy[k];
                            if (inArea(a, b) && grid[a][b] == '1') {
                                grid[a][b] = '0';
                                deque.add(a * n + b);
                            }
                        }
                    }

                }
            }
        }

        return num;
    }
    //--------------循环版dfs------------//


    //------------bfs--------------//
    public int numIslands3(char[][] grid) {
        if (grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '0';

                    Deque<Integer> deque = new LinkedList<>();
                    deque.add(i * n + j);

                    while (!deque.isEmpty()) {
                        int cell = deque.pollFirst();
                        int r = cell / n;
                        int c = cell % n;

                        for (int k = 0; k < 4; k++) {
                            int a = r + dx[k], b = c + dy[k];
                            if (inArea(a, b) && grid[a][b] == '1') {
                                grid[a][b] = '0';
                                deque.add(a * n + b);
                            }
                        }
                    }
                }
            }
        }
        return num;
    }
    //------------bfs--------------//

    private boolean inArea(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(new _200_NumIslands().numIslands2(grid));
    }
}
