class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int n = nums1.length;
      int[] ans = new int[n];
      for(int i = 0;i<n;i++){
        int place = place(nums2, nums1[i]);
        int gEle = helper(nums2, place, nums1[i]);
        ans[i] = gEle;
      } 
      return ans; 
    }

    public int place(int[] nums, int target){
        for(int i =0;i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    public int helper(int[] nums, int i, int target){
        while(i < nums.length){
            if(nums[i] > target){
                return nums[i];
            }
            i++;
        }
        return -1;
    }

}