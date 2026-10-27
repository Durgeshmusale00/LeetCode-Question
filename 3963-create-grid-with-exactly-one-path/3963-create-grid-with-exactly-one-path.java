class Solution {
    private boolean flag = false;
    public String[] createGrid(int m, int n) {
        flag = false;
        String[][] grid = new String[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], "#");
        }
        grid[0][0] = ".";
        helper(grid, 0, 0);
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                temp+=grid[i][j];
            }
            ans[i] = temp;
        }
        return ans;
    }

    private void helper(String[][] grid, int row, int col) {
        if (flag) return;

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            flag = true;
            return;
        }

        int[] dRow = {0, 1};
        int[] dCol = {1, 0};

        for (int i = 0; i < 2; i++) {
            int dr = row + dRow[i];
            int dc = col + dCol[i];

            if ((dr >= 0 && dr < grid.length) && (dc >= 0 && dc < grid[0].length) && (grid[dr][dc].equals("#"))) {
                grid[dr][dc] = ".";
                helper(grid, dr, dc);
                if (flag) return;
                grid[dr][dc] = "#";
            }
        }
    }
}