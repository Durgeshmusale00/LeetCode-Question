class Solution {
    private int ans = 0;

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queen(board, 0);
    }

    public int queen(boolean[][] board, int row) {
        //base case
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = true;
                count += queen(board, row + 1);
                board[row][i] = false;
            }
        }
        return count;
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        //chekking the upside.
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left daigonal
        int leftMin = Math.min(row, col);
        for (int i = 1; i <= leftMin; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        int rightMin = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= rightMin; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
}