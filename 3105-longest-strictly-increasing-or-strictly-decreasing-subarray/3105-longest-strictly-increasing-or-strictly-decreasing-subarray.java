class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        return helperI(nums);
    }

   
public int helperI(int[] nums) {

    int n = nums.length;
    if (n == 0) return 0;

    int left = 0;
    int right = 1;
    int ans = 1;

    while (right < n) {

        if (nums[right - 1] < nums[right]) {
            if (right - left > 1 &&
                nums[right - 2] > nums[right - 1]) {
                left = right - 1;
            }
        }
        else if (nums[right - 1] > nums[right]) {
            if (right - left > 1 &&
                nums[right - 2] < nums[right - 1]) {
                left = right - 1;
            }
        }
        else {
            left = right;
        }

        ans = Math.max(ans, right - left + 1);
        right++;
    }

    return ans;
}
}