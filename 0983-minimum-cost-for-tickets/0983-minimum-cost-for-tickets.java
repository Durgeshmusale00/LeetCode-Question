class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(days, 0, costs, dp);
    }

    public int helper(int[] days, int i, int[] costs, int[] dp) {

        // Base case
        if (i >= days.length) {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        // 1-day pass
        int one = costs[0] + helper(days, i + 1, costs, dp);

        // 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }

        int seven = costs[1] + helper(days, j, costs, dp);

        // 30-day pass
        int k = i;
        while (k < days.length && days[k] < days[i] + 30) {
            k++;
        }

        int thirty = costs[2] + helper(days, k, costs, dp);

        return dp[i] = Math.min(one, Math.min(seven, thirty));
    }
}