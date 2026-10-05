class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp, -1);
      return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int i, int[] dp){
        //base case 
        if(i >= nums.length){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        //choose 
        int choose = nums[i] + helper(nums, i+2, dp);

        //not choose 
        int notChoose = helper(nums, i+1, dp);

        return dp[i] = Math.max(choose, notChoose);
    }
}