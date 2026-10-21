class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    int i = 0;
    int j = nums.length-1;
    while(i < j){
    int sum = nums[i] + nums[j];
    if(sum > target){
        j--;
    }else if(sum < target){
        i++;
    }
    if(sum == target){
        ans[0] = i+1;
        ans[1] = j+1;
        break;
    }
    }
        return ans;
    }
}