class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0, two = 0;
        for (int i = 2; i <= cost.length; i++) {
            int current = Math.min(two + cost[i - 2], one + cost[i - 1]);
            two = one;
            one = current;
        }
        return one;
    }
}