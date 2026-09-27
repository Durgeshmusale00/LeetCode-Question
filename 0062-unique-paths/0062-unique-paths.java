class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=m;j++){
                dp[i][j] = -1;
            }
        }
        int ans = helper(m, n, dp);
        return ans;
    }
    public int helper(int r, int c, int[][] dp){
        //b c 
    
        if(r == 1 || c == 1){
            return 1;
        }
        if(dp[c][r] != -1) return dp[c][r];

        int right = helper(r-1, c, dp);
        int down = helper(r, c-1, dp);

        return dp[c][r] = right + down;
    }
}
