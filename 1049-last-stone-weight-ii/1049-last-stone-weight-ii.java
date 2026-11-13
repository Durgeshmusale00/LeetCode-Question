class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int ele : stones) {
            sum += ele;
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int best = helper(stones, 0, target, 0, dp);
        return sum - 2 * best;
    }

    public int helper(int[] nums, int i, int target, int curr, int[][] dp) {

        // Base case
        if (i == nums.length) {
            return curr;
        }

        if (dp[i][curr] != -1) {
            return dp[i][curr];
        }

        // Choose
        int take = 0;

        if (curr + nums[i] <= target) {
            take = helper(nums, i + 1, target, curr + nums[i], dp);
        }

        // Not choose
        int notTake = helper(nums, i + 1, target, curr, dp);

        return dp[i][curr] = Math.max(take, notTake);
    }
}
