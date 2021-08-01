package hard;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class _37_SolveSudoku {

    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][] blocks;
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;

        this.rows = new boolean[9][9];
        this.cols = new boolean[9][9];
        this.blocks = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '1';

                if (num != -3) {  //  -3 --> '.'
                    rows[i][num] = true;
                    cols[j][num] = true;
                    blocks[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }

        backtrace(0, 0);
    }

    private boolean backtrace(int row, int col) {
        while (board[row][col] != '.') {
            col++;

            if (col == 9) {
                row++;
                col = 0;
            }

            if (row == 9) return true;
        }

        for (int num = 0; num < 9; num++) {
            int blockIndex = row / 3 * 3 + col / 3;
            if (!rows[row][num] && !cols[col][num] && !blocks[blockIndex][num]) {
                rows[row][num] = cols[col][num] = blocks[blockIndex][num] = true;
                board[row][col] = (char) ('1' + num);

                boolean ans = backtrace(row, col);
                if (ans) return true;

                board[row][col] = '.';
                rows[row][num] = cols[col][num] = blocks[blockIndex][num] = false;
            }
        }
        return false;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        _37_SolveSudoku solution = new _37_SolveSudoku();
        solution.solveSudoku(board);
        solution.printBoard(board);
    }
}
