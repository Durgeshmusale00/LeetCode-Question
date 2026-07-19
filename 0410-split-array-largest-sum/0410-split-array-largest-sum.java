class Solution {
    public int splitArray(int[] weights, int days) {
       
        int start = java.util.Arrays.stream(weights).reduce(0, Math::max);
        int end = java.util.Arrays.stream(weights).sum();

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (helper(weights, days, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start; 
    }

      public boolean helper(int[] nums, int days, int capacity) {

        int sum = 0;
        days--;

        for (int num : nums) {
            if (sum + num <= capacity) {
                sum += num;
            } else {
                sum = num;
                days--;

                if (days < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}