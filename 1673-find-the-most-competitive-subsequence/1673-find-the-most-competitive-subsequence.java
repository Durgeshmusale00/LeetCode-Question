class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        int remDrops = nums.length - k;
        int top = -1;
        for (int i = 0; i < nums.length; i++) {
            while (top >= 0 && nums[i] < ans[top] && remDrops > 0) {
                top--;
                remDrops--;
            }

            if (top < k - 1) {
                ans[++top] = nums[i];
            } else {
                remDrops--;
            }
        }
        return ans;
    }
}