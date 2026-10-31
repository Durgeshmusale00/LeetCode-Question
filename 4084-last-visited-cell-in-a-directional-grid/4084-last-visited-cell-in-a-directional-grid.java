class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] ans = { -1, -1 };
        helper(grid, 0, 0, vis, ans);
        return ans;
    }

    public void helper(char[][] grid, int i, int j, boolean[][] vis, int[] ans) {
        vis[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;

        boolean flag = false;
        if (grid[i][j] == 'R' && j + 1 < m && !vis[i][j + 1]) {
            helper(grid, i, j + 1, vis, ans);
            flag = true;
        } else if (grid[i][j] == 'D' && i + 1 < n && !vis[i + 1][j]) {
            helper(grid, i + 1, j, vis, ans);
            flag = true;
        } else if (grid[i][j] == 'L' && j - 1 >= 0 && !vis[i][j - 1]) {
            helper(grid, i, j - 1, vis, ans);
            flag = true;
        } else if (grid[i][j] == 'U' && i - 1 >= 0 && !vis[i-1][j]) {
            helper(grid, i - 1, j, vis, ans);
            flag = true;
        }

        if (!flag) {
            ans[0] = i;
            ans[1] = j;
        }
    }
}