import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> st = new Stack<>();

        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            // Found 132 pattern
            if (nums[i] < second) {
                return true;
            }

            // Find possible 2
            while (!st.isEmpty() &&
                   st.peek() < nums[i]) {

                second = st.pop();
            }

            // Store possible 3
            st.push(nums[i]);
        }

        return false;
    }
}