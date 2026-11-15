class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int idx = 0;
        for(int i= 0;i<nums.length;i++){
            int curr =  nums[i];
            int count = 0;
            for(int j = 0;j<n;j++){
                if(nums[j] < curr){
                    count++;
                }
            }
            arr[idx++] = count;
        }
        return arr;
    }
}