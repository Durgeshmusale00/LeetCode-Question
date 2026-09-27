class Solution {
    public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] dp = new int[n+1][m+1];
    for(int i = 0;i<=n;i++){
        for(int j = 0;j<=m;j++){
            dp[i][j] = -1;
        }
    }

    int ans = helper(grid, m-1, n-1, dp);
    return ans;
    }
    public int helper(int[][] grid, int r, int c, int[][] dp){
    int n = grid.length;
    int m = grid[0].length;
     
    if(r == 0 && c == 0){
    return grid[c][r];
    }

    if(r < 0 || c < 0){
    return Integer.MAX_VALUE;
    }

    //b c 
    if(dp[c][r] != -1) return dp[c][r];

    int right = helper(grid, r-1, c, dp);
    int down = helper(grid, r, c-1, dp);
    int ans = Math.min(right, down) + grid[c][r];
    return dp[c][r] = ans;
    }

}