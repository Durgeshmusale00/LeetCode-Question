class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
             if(!vis[i][j] && grid[i][j] == 0){
               if (helper(grid, i, j, vis)) {
                        ans++;
                    }
             }
            }
        }
        return ans;

    }

    public boolean helper(int[][] grid, int i, int j, boolean[][] vis) {
        //mark the true;
        vis[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;

         boolean closed = (i != 0 && i != n - 1 && j != 0 && j != m - 1);

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        for (int idx = 0; idx < 4; idx++) {
            int nr = i + dr[idx];
            int nc = j + dc[idx];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && ! vis[nr][nc] && grid[nr][nc] == 0) {
                if (!helper(grid, nr, nc, vis)) {
                    closed = false;
                }
            }
        }

        return closed;
}
}