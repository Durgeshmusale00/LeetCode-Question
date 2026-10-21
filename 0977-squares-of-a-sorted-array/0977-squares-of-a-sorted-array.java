class Solution {
    public int[] sortedSquares(int[] nums) {
      for(int i  = 0;i<nums.length;i++){
        int sq = Math.abs(nums[i]) * Math.abs(nums[i]);
        nums[i] = sq;
      }  
      Arrays.sort(nums);
      return nums;
    }
}