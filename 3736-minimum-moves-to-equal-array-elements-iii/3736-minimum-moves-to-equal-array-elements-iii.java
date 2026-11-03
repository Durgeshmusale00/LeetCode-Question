class Solution {
    public int minMoves(int[] nums) {
     int max = Integer.MIN_VALUE;
     for(int i = 0;i<nums.length;i++){
        if(nums[i] > max){
            max = nums[i];
        }
     }   

     int ans = 0;
        for(int i = 0;i<nums.length;i++){
          int temp = Math.abs(max - nums[i]);  
          ans+=temp;
        }
        return ans;
    }
}