class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remender = sum % k;
            if (map.containsKey(remender)) {
                int previousIndex = map.get(remender);

                if (i - previousIndex >= 2) {
                    return true;
                }
            } else {
                    map.put(remender, i);
            }
        }
        return false;
    }
}