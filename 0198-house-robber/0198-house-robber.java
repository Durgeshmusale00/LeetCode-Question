class Solution {
    public int rob(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int i, int[] dp){
        //base case 
        if(i >= nums.length) return 0;


        //memoization 
        if(dp[i] != -1) return dp[i];

        int frist = nums[i] + helper(nums, i+2, dp);
        int second = helper(nums, i+1, dp);

        return dp[i] = Math.max(frist, second);
    }
}