class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       return helper(nums, 0, 0, target); 
    }
    public int helper(int[] nums, int i, int curr, int target){
        //base case 
        if(i == nums.length){
            if(curr == target){
              return 1;
            }
            return 0;
        }


        //choose plus
        int choose = helper(nums, i+1, curr+nums[i], target);

        //choose minus
        int notChoose = helper(nums, i+1,  curr-nums[i], target);
        
        return choose + notChoose;
    }
}