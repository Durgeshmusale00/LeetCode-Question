class Solution {
    public void moveZeroes(int[] nums) {
    int cnd = 0;
    int n = nums.length;
    for(int i = 0;i<nums.length;i++){
        if(nums[i] != 0){
           nums[cnd++] = nums[i];
        }
    } 
    while(cnd < n){
        nums[cnd++] = 0;
    } 
    }
}