class Solution {
    public int rob(int[] nums) {
      if(nums.length == 1) return nums[0];
      int n = nums.length;
      int[] dp = new int[n+1];
      Arrays.fill(dp, -1);
      int Zc = helper(nums, 0, dp);
      int[] dp1 = new int[n+1];
      Arrays.fill(dp1, -1);
      int Oc = helper1(nums, 1, dp1);
      return Math.max(Zc, Oc);
    }

    public int helper(int[] nums, int i, int[] dp) {
        //base case 
        if (i > nums.length-2) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        //choose 
        int choose = nums[i] + helper(nums, i + 2, dp);

        //not choose 
        int notChoose = helper(nums, i + 1, dp);

        return dp[i] = Math.max(choose, notChoose);
    } 
    
    public int helper1(int[] nums, int i, int[] dp) {
        //base case 
        if (i > nums.length-1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        //choose 
        int choose = nums[i] + helper1(nums, i + 2, dp);

        //not choose 
        int notChoose = helper1(nums, i + 1, dp);

        return dp[i] = Math.max(choose, notChoose);
    }
}