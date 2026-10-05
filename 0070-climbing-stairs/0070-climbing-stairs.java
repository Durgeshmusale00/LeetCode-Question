class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        stair(n, dp);
        return dp[n];
    }

    public int stair(int n, int[] dp) {
        //base case 
        if (n <= 2) {
            return dp[n] = n;
        }

        //cheking the before calling is this available in our dp.
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = stair(n - 1, dp) + stair(n - 2, dp);
    }
}