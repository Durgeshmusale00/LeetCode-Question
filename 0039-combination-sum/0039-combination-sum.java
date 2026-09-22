class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> partial_ans = new ArrayList<>();
    helper(0, target, 0, candidates, partial_ans, ans);
    return ans;
    }
    public void helper(int i, int target, int sum, int[] nums, ArrayList<Integer> partial_ans, List<List<Integer>> ans){
        //base case 
        if(target==sum){
             ans.add(new ArrayList<>(partial_ans)); 
            return;
        }
        if(i > nums.length) return;


        //choose 
        if(sum > target || i >= nums.length) return;
        partial_ans.add(nums[i]);
        helper(i, target, sum+nums[i], nums, partial_ans, ans);
        partial_ans.remove(partial_ans.size() - 1); 


        //not choose
        helper(i+1, target, sum, nums, partial_ans, ans);
    }
}