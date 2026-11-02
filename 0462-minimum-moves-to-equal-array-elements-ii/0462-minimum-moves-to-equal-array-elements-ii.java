class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long temp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j){
                    continue;
                }
               long an = (long) nums[i] - nums[j];
                temp += Math.abs(an);
            }
            min = Math.min(min, temp);
        }
        return (int) min;
    }
}