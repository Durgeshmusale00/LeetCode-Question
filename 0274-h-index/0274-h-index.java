class Solution {
    public int hIndex(int[] nums) {

        // finding max
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // binary search
        int start = 0;
        int end = max;
        int ans = 0;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int possibleAns = helper(nums, mid);

            if (possibleAns >= mid) {
                // mid can be an H-index
                ans = mid;
                start = mid + 1;
            } else {
                // mid is too large
                end = mid - 1;
            }
        }

        return ans;
    }

    public int helper(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                count++;
            }
        }

        return count;
    }
}