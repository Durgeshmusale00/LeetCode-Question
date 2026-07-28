class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int idx = 0;
    for(int i = 0;i<n;i++){
        int temp = helper(nums, nums[i], i);
       ans[idx++] = temp;
    }
    return ans;
  }

  public int helper(int[] nums, int target, int i){ 
    int n = nums.length;
        for (int j = 1; j < n; j++) {
        int index = (i + j) % n;

        if (nums[index] > nums[i]) {
            return nums[index];
        }
    }
        return -1;
  }
}