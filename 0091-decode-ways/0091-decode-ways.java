class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    public int helper(String s, int i, int[] dp) {
        //base case 
        if (i >= s.length()) {
            return dp[i] = 1;
        }

        if(dp[i] != -1) return dp[i];

        int first = 0;
        int second = 0;

        //call for the single digit. 
        if (Character.getNumericValue(s.charAt(i)) >= 1 && Character.getNumericValue(s.charAt(i)) <= 9) {
            first = helper(s, i + 1, dp);
        }

        //call for the 2 digit if they are less than 26 and the grether or queal to 2.
        if (i + 2 <= s.length()) {
            String str = s.substring(i, i + 2);
            int num = Integer.parseInt(str);

            if (num >= 10 && num <= 26) {
                second = helper(s, i + 2, dp);
            }
        }
        return dp[i] =  first + second;
    }
}