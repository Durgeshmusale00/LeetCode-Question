class Solution {

    public boolean predictTheWinner(int[] nums) {
        int diff = helper(nums, 0, nums.length - 1);
        return diff >= 0;
    }

    public int helper(int[] nums, int left, int right) {

        // Only one number remains
        if (left == right) {
            return nums[left];
        }

        // Current player chooses left
        int chooseLeft = nums[left] - helper(nums, left + 1, right);

        // Current player chooses right
        int chooseRight = nums[right] - helper(nums, left, right - 1);

        // Current player chooses the better option
        return Math.max(chooseLeft, chooseRight);
    }
}