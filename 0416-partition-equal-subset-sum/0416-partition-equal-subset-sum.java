class Solution {
    private boolean flag = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2 != 0) return false;
        Boolean[][] dp = new Boolean[n][sum+1]; 
        return helper(nums, 0, sum/2, dp);
    }

    public boolean helper(int[] nums, int i,int total, Boolean[][] dp) {
       //base case 
       if(total == 0){
        return true;
       }

       if(i == nums.length){
        return false;
       }
       if(dp[i][total] != null) return dp[i][total];

       boolean take = false;
       if(total>=nums[i]){
        take = helper(nums, i+1,  total-nums[i], dp);
       }

       
        boolean notTake = helper(nums, i+1,  total, dp);
       
       
        return dp[i][total] =  take || notTake;

    }
}