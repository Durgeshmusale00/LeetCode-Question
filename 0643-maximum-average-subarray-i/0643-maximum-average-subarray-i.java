class Solution {
    public double findMaxAverage(int[] nums, int k) {
     int sum = 0;
     for(int i=  0;i<k;i++){
        sum+=nums[i];
     } 
     int maxSum = sum;
     int left = 0;
     int right = k; 

     while(right < nums.length){
      sum = sum - nums[left] + nums[right];
       maxSum = Math.max(maxSum, sum);
       right++;
       left++;
     } 
     return( double) maxSum/k;
    }
}