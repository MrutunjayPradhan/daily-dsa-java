import java.util.HashSet;

public class Day30_36_Solution {

    public boolean isValidSudoku(char[][] board) {
        // Initialize hash sets to track numbers in rows, columns, and boxes.
        @SuppressWarnings("unchecked")
        HashSet<Character>[] rows = new HashSet[9];
        @SuppressWarnings("unchecked")
        HashSet<Character>[] cols = new HashSet[9];
        @SuppressWarnings("unchecked")
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Iterate through each cell in the 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Skip empty cells
                if (num == '.')
                    continue;

                // Calculate box index
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check for duplicates in the current row, column, or box
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }

                // Add the number to the current row, column, and box
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }
        return true;
    }

}
