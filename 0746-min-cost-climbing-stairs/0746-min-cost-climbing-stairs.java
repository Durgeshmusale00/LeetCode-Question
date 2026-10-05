class Solution {
    public int minCostClimbingStairs(int[] cost) {
     int n = cost.length;
     int[] dp = new int[n];
     Arrays.fill(dp, -1);
     int one= helper(cost, 0, dp);
     int two = helper(cost, 1, dp);

     return Math.min(one, two);
    }

    public int helper(int[] cost, int i, int[] dp){
        //base case 
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int one_Step = helper(cost,  i+1, dp);
        int two_Step = helper(cost, i+2, dp);

        dp[i] = cost[i] + Math.min(one_Step, two_Step);

        return dp[i];
    }
}