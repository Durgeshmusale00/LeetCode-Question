class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        long[] dp = new long[power.length];
        Arrays.fill(dp, -1L);
        return helper(power, 0, dp);
    }

    public long helper(int[] nums, int i, long[] dp) {
        //base case 
        if (i >= nums.length) {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int j = i;
        long point = 0;
        while (j < nums.length && nums[i] == nums[j]) {
            point += nums[j++];
        }
        while (j < nums.length && (nums[i] + 1 == nums[j] || nums[i] + 2 == nums[j])) {
            j++;
        }

        long choose = point + helper(nums, j, dp);

        int k = i;
        while (k < nums.length && nums[i] == nums[k]) {
            k++;
        }

        long notChoose = helper(nums, k, dp);

        return dp[i] = Math.max(choose, notChoose);

    }
}