public class Day19_3484_Solution {
    class Spreadsheet {
    private int[][] grid;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        grid = new int[rows][26];
        // Initialize all cells to 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 26; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void setCell(String cell, int value) {
        int[] indices = parseCell(cell);
        int row = indices[0];
        int col = indices[1];
        grid[row][col] = value;
    }

    public void resetCell(String cell) {
        int[] indices = parseCell(cell);
        int row = indices[0];
        int col = indices[1];
        grid[row][col] = 0;
    }

    public int getValue(String formula) {
        // Formula is of the form "=X+Y"
        String expr = formula.substring(1); // Remove the '='
        String[] parts = expr.split("\\+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid formula");
        }
        int val1 = getValueFromPart(parts[0]);
        int val2 = getValueFromPart(parts[1]);
        return val1 + val2;
    }

    private int getValueFromPart(String part) {
        if (part.matches("\\d+")) {
            return Integer.parseInt(part);
        } else {
            // It is a cell reference
            int[] indices = parseCell(part);
            int row = indices[0];
            int col = indices[1];
            return grid[row][col];
        }
    }

    private int[] parseCell(String cell) {
        // Cell format: [A-Z][1-rows]
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // Convert to 0-indexed
        if (row < 0 || row >= rows || col < 0 || col >= 26) {
            throw new IllegalArgumentException("Invalid cell reference");
        }
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
}
