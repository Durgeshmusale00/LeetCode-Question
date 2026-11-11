class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp, -1);
      dp[0] = nums[0];
      int ans= dp[0];
      for(int i = 1;i<nums.length;i++){
        dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);

        ans = Math.max(ans, dp[i]);
      }  
      return ans;
    }
}