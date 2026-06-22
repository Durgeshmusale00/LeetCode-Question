class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n + 1];  // dp[i] = people who learn secret on day i
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i + delay; j < Math.min(i + forget, n + 1); j++) {
                dp[j] = (dp[j] + dp[i]) % MOD;
            }
        }

        long ans = 0;
        // count those who haven't forgotten by day n
        for (int i = n - forget + 1; i <= n; i++) {
            if (i > 0) ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }
}
