class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int n = nums1.length;
       int[] ans = new int[n];
       for(int i = 0;i<n;i++){
        int temp = helper(nums2, nums1[i]);
        ans[i] = temp;
       } 
       return ans;
    }

    public int helper(int[] nums, int target){
        int idx = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                idx = i;
            }
        }

       if(idx == -1) return -1;

       for(int i = idx;i<nums.length;i++){
        if(nums[idx] < nums[i]){
            return nums[i];
        }
       }
       return -1;
    }
}