class Solution {
    public boolean canJump(int[] nums) {
      int n = 0;
      int maxReach = 0;
      for(int i = 0;i<nums.length;i++){
        if(i > maxReach) return false;
        maxReach = Math.max(maxReach, i+nums[i]);
      }  
      return true;
    }
}