class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int ele = nums[i];

            // Add current element
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            // If frequency exceeds k, remove from left
            while (map.get(ele) > k) {
                int leftEle = nums[left];

                map.put(leftEle, map.get(leftEle) - 1);

                left++;
            }

            // Current valid subarray length
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}