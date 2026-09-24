class Solution {
    public int smallestIndex(int[] nums) {
    for(int i = 0;i<nums.length;i++){
        if(helper(nums[i], i)){
            return i;
        }
    }
    return -1;
    }

    public boolean helper(int n, int target){
    if(n < 10){
        return n == target;
    }else{
        int nCopy = n;
        int sum = 0;
        while(nCopy > 0){
            int temp = nCopy%10;
            sum+=temp;
            nCopy/=10;
        }
        return sum == target;
    }
    }
}