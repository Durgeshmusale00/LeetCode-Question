class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1])continue;

            for(int j=i+1;j<n-1;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int target = 0-(nums[i] + nums[j]);

                if(find(nums,j+1,n-1,target)){
                    ls.add(Arrays.asList(nums[i],nums[j],target));
                }
                

            }
        }
        return ls;
        
    }
    public boolean find(int[] nums,int st,int ed,int target){
        while(st<=ed){
            int mid = st+(ed-st)/2;

            if(nums[mid]==target)return true;
            else if(nums[mid]>target)ed = mid-1;
            else{
                st = mid+1;
            }

        }
        return false;

    }
}