class Solution {
    public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    return helper(s, 0, dp); 
    }

 public int helper(String s, int i, int[] dp) {

    // Base case
    if (i == s.length()) {
        return 1;
    }

    if (s.charAt(i) == '0') {
        return 0;
    }

    int count = 0;
    if(dp[i] != -1) return dp[i];

    // Choose one digit
    count += helper(s, i + 1, dp);

    // Choose two digits
    if (i + 1 < s.length()) {
        int num = Integer.parseInt(s.substring(i, i + 2));

        if (num >= 10 && num <= 26) {
            count += helper(s, i + 2, dp);
        }
    }

    return dp[i] = count;
}
}