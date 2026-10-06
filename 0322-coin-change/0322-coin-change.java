class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = helper(coins, 0, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int[] coin, int i, int amount, int[][] dp) {
        // Base case
        if (amount == 0) {
            return 0;
        }

        if (amount < 0 || i >= coin.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Choose
        int choose = helper(coin, i, amount - coin[i], dp);

        if (choose != Integer.MAX_VALUE) {
            choose = choose + 1;
        }

        // Not choose
        int notChoose = helper(coin, i + 1, amount, dp);

        return dp[i][amount] = Math.min(choose, notChoose);
    }
}