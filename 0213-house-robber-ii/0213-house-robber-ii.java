class Solution {
    public int rob(int[] nums) {
    int n = nums.length;
    int[] dp1 = new int[n];
    Arrays.fill(dp1, -1);
     int[] dp2 = new int[n];
    Arrays.fill(dp2, -1);
    if(nums.length == 1) return nums[0];
      return Math.max(helperZ(nums, 0, dp1), helperO(nums, 1, dp2));
    }

    public int helperZ(int[] nums, int i, int[] dp){
     //base case 
     if(i >= nums.length-1){
        return 0;
     }   

     if(dp[i] != -1) return dp[i];

     int choose  = nums[i] + helperZ(nums, i+2, dp);

     int notChoose  = helperZ(nums, i+1, dp);

     return dp[i] = Math.max(choose, notChoose);
    }

     public int helperO(int[] nums, int i, int[] dp){
     //base case 
     if(i >= nums.length){
        return 0;
     } 
     if(dp[i] != -1) return dp[i];  

     int choose  = nums[i] + helperO(nums, i+2, dp);

     int notChoose  = helperO(nums, i+1, dp);

     return dp[i] = Math.max(choose, notChoose);
    }
}