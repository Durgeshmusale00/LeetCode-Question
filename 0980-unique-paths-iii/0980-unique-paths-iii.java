class Solution {

    static int count = 0;
    static int ans = 0;

    public int uniquePathsIII(int[][] grid) {

        count = 0;
        ans = 0;

        int row = -1;
        int col = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    count++;
                }

                // Start from 1
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }

        isSafe(grid, row, col, -1);

        return ans;
    }

    static void isSafe(int[][] grid, int i, int j, int visit) {

        // Boundary check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        // Obstacle or visited
        if (grid[i][j] == -1) {
            return;
        }

        // Destination
        if (grid[i][j] == 2) {
            if (visit == count) {
                ans++;
            }
            return;
        }

        // Save original value
        int temp = grid[i][j];
        grid[i][j] = -1;

        // Explore 4 directions
        isSafe(grid, i - 1, j, visit + 1);
        isSafe(grid, i, j + 1, visit + 1);
        isSafe(grid, i + 1, j, visit + 1);
        isSafe(grid, i, j - 1, visit + 1);

        // Backtrack
        grid[i][j] = temp;
    }
}