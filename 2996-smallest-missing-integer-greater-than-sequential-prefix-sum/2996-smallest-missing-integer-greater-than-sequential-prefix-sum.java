class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find sum of longest consecutive prefix
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find the smallest integer >= sum
        // that is not present in nums
        while (isThere(nums, sum)) {
            sum++;
        }

        return sum;
    }

    public boolean isThere(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }

        return false;
    }
}