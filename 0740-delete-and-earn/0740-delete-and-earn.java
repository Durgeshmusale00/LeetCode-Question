class Solution {
    public int deleteAndEarn(int[] nums) {
     int max = Integer.MIN_VALUE;
     int n = nums.length;
     for(int i = 0;i<nums.length;i++){
        if(nums[i] > max){
            max = nums[i];
        }
     }   

     int[] dp = new int[max+1];
     for(int i = 0;i<nums.length;i++){
        dp[nums[i]] += nums[i];
     }
    int[] memo = new int[max+1];
    Arrays.fill(memo,-1);
    return helper(dp, max, memo);
    }

    public int helper(int[] dp, int i, int[] memo){
      //base case 
      if(i < 0){
        return 0;
      }

      if(memo[i] != -1) return memo[i];

      int choose = dp[i] + helper(dp, i-2,memo);

      int notChoose = helper(dp, i-1, memo);
     
      return memo[i] = Math.max(choose, notChoose);  
    }
}