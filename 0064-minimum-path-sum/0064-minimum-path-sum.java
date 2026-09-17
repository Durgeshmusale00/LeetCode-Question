class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        
        return helper(grid, 0, 0, memo);
    }

    private int helper(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int right = helper(grid, i, j + 1, memo);
        int down = helper(grid, i + 1, j, memo);

        memo[i][j] = grid[i][j] + Math.min(right, down);

        return memo[i][j];
    }
}
