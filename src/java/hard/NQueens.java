package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            for (int j = 0; j < n; j++) {
                c[j] = '.';
            }
            board.add(c);
        }

        List<List<String>> ans = new ArrayList<>();
        backtrack(n, new boolean[n << 2 - 1], new boolean[n << 2 - 1], new boolean[n], board, 0, ans);
        return ans;
    }

    private void backtrack(int n, boolean[] masters, boolean[] slaves, boolean[] columns, List<char[]> board, int row, List<List<String>> ans) {
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;
            if (!(masters[d1] || slaves[d2] || columns[col])) {
                board.get(row)[col] = 'Q';
                columns[col] = true;
                masters[d1] = true;
                slaves[d2] = true;

                if (row + 1 == n) {
                    List<String> solution = new ArrayList<>(board.size());
                    for (char[] r : board) {
                        solution.add(new String(r));
                    }
                    ans.add(solution);
                } else {
                    backtrack(n, masters, slaves, columns, board, row + 1, ans);
                }

                board.get(row)[col] = '.';
                columns[col] = false;
                masters[d1] = false;
                slaves[d2] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
