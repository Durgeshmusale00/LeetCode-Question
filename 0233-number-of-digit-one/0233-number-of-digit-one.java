class Solution {
    public int countDigitOne(int n) {
        int ans = 0;

        for (long factor = 1; factor <= n; factor *= 10) {

            long higher = n / (factor * 10);
            long current = (n / factor) % 10;
            long lower = n % factor;

            if (current == 0) {
                ans += higher * factor;
            }
            else if (current == 1) {
                ans += higher * factor + lower + 1;
            }
            else {
                ans += (higher + 1) * factor;
            }
        }

        return ans;
    }
}