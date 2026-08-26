class Solution {
    public int subarraysDivByK(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
     map.put(0,1);
    int sum = 0;
    int count = 0;
    for(int i = 0;i<nums.length;i++){
        sum+=nums[i];
        int mod = (sum%k + k)%k;
        if(map.containsKey(mod)){
            // count++;
            count+=map.get(mod);
        }
        map.put(mod, map.getOrDefault(mod, 0) + 1);
      }
      return count;
    }
}