public class Day31_37_Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Iterate over each cell to find empty spots ('.')
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {  // Empty cell found
                    // Try placing each number from '1' to '9'
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;  // Place the number
                            if (solve(board)) {  // Recursively solve the rest of the board
                                return true;  // Solution found
                            }
                            board[row][col] = '.';  // Backtrack if placing `num` didn't work
                        }
                    }
                    return false;  // No valid number could be placed here, need to backtrack
                }
            }
        }
        return true;  // Solved the puzzle if no empty cell is left
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check if `num` is unique in row, column, and 3x3 sub-box
        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
            // Check 3x3 sub-box
            int subBoxRow = 3 * (row / 3) + i / 3;
            int subBoxCol = 3 * (col / 3) + i % 3;
            if (board[subBoxRow][subBoxCol] == num) {
                return false;
            }
        }
        return true;  // `num` can be placed in this cell
    }
}
