class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int i, int[] dp) {
        //base case
        if (i >= nums.length) {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int j = i;
        int chose = 0;
        while (j < nums.length && nums[i] == nums[j]) {
            chose += nums[j++];
        }

        while (j < nums.length && nums[i] + 1 == nums[j]) {
            j++;
        }

       
        int choose = chose + helper(nums, j, dp);

        // Not choose
        int k = i;

        while (k < nums.length && nums[k] == nums[i]) {
            k++;
        }

        int notChoose = helper(nums, k, dp);

        return dp[i] = Math.max(notChoose, choose);
    }
}