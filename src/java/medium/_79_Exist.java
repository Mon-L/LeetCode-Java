package medium;

public class _79_Exist {

    private int n;
    private int m;
    private final int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;

        m = board.length;
        n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (backtrack(board, visited, word, x, y, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, String word, int x, int y, int pos) {
        if (pos == word.length() - 1) {
            return board[x][y] == word.charAt(pos);
        }

        if (word.charAt(pos) == board[x][y]) {
            visited[x][y] = true;
            for (int[] d : direction) {
                int x1 = x + d[0], y1 = y + d[1];

                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || visited[x1][y1]) {
                    continue;
                }

                if (backtrack(board, visited, word, x1, y1, pos + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A'}
        };
        System.out.println(new _79_Exist().exist(chars, "A"));
    }
}
