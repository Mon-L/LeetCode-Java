package medium;

import model.UnionFindSet2;

public class _130_Solve {

    private int m;
    private int n;
    private char[][] board;

    //--------深度优先搜索
    public void solve(char[][] board) {
        if (board.length == 0) return;

        this.m = board.length;
        this.n = board[0].length;
        this.board = board;

        for (int i = 0; i < n; i++) {
            dfs(0, i);
            dfs(m - 1, i);
        }

        for (int i = 1; i < m - 1; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }

        board[x][y] = 'A';
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
    //--------深度优先搜索

    //--------并查集
    public void solve2(char[][] board) {
        if (board.length == 0) return;

        this.m = board.length;
        this.n = board[0].length;
        this.board = board;

        int N = m * n, dummyNode = N;
        UnionFindSet2 uf = new UnionFindSet2(N + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int node = node(i, j);

                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {

                        uf.union(dummyNode, node);

                    } else {
                        if (board[i - 1][j] == 'O') {
                            uf.union(node, node(i - 1, j));
                        }

                        if (board[i][j - 1] == 'O') {
                            uf.union(node, node(i, j - 1));
                        }

                        if (i < m - 1 && board[i + 1][j] == 'O') {
                            uf.union(node, node(i + 1, j));
                        }

                        if (j < n - 1 && board[i][j + 1] == 'O') {
                            uf.union(node, node(i, j + 1));
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && uf.find(node(i, j)) != uf.find(dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int i, int j) {
        return i * n + j;
    }
    //--------并查集

    private static void print(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        new _130_Solve().solve2(board);
        print(board);

        board = new char[][]{
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}
        };
        new _130_Solve().solve2(board);
        print(board);

        board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        new _130_Solve().solve2(board);
        print(board);
    }
}
