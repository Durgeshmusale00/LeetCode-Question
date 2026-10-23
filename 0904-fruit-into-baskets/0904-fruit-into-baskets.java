class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int maxAns = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

                while (map.size() > 2) {
                    int fruit = nums[left];

                    map.put(fruit, map.get(fruit) - 1);

                    if (map.get(fruit) == 0) {
                        map.remove(fruit);
                    }
                    left++;
                }
            
            maxAns = Math.max(maxAns, right-left+1);
        }
        return maxAns;
    }
}