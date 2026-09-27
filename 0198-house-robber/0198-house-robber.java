class Solution {
    public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    for(int i = 0;i<dp.length;i++){
        dp[i] = -1;
    }
      return helper(nums, 0, dp);
    }

    public int helper(int[] arr, int i, int[] dp){
        //base case 
        if(i >= arr.length) {
            return 0;
        }
        if(dp[i] != -1)return dp[i];
        //choose
         int choose = arr[i] + helper(arr, i+2, dp);
        //not choose 
        int noChoose = helper(arr, i+1, dp);

        return dp[i] = Math.max(choose, noChoose);
    }
}