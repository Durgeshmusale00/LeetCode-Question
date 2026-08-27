class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++) {
            if(i>0) if(nums[i] == nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            while(j<k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; 
                    while(j<k && nums[j] == nums[j-1]) j++;
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                    
                }
                else if(nums[j] + nums[k] > 0-nums[i]) k--;
                else j++;
            }
        }

        return result;
    }
}