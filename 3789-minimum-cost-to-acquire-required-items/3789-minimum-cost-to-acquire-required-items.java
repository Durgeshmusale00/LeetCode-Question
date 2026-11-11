class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = (long) need1 * cost1 + (long) need2 * cost2;
        long both = (long) Math.min(need1, need2) * costBoth;

        both += (long) (need1 - Math.min(need1, need2)) * cost1;
        both += (long) (need2 - Math.min(need1, need2)) * cost2;
        ans = Math.min(ans, both);

        long allBoth = (long) Math.max(need1, need2) * costBoth;
        ans = Math.min(ans, allBoth);

        return ans;
    }
}