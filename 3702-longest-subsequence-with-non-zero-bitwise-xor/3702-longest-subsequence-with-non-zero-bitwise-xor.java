class Solution {
    public int longestSubsequence(int[] nums) {
     int n = nums.length;
     int xor = 0;
     for(int num : nums){
       xor = xor ^ num;
     }   

     if(xor != 0){
        return n;
     }else{
        boolean flag = false;
        for(int i = 0;i<n;i++){
            if(nums[i] >= 1) flag = true;
        }
        if(flag){
            return n -1;
        }else{
            return 0;
        }
     }
    }
}