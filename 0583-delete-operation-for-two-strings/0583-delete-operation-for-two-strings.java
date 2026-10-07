class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
      int len = helper(word1, word2, 0, 0, dp);
      return (n-len)+(m-len);
    }

     public int helper(String s1, String s2, int i, int j, int[][] dp){
        //base case 
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int match =0;

        if(s1.charAt(i) == s2.charAt(j)){
            match = 1 + helper(s1, s2, i+1, j+1, dp);
        }

        return dp[i][j] = Math.max(match, Math.max(helper(s1,s2,i+1,j, dp) , helper(s1,s2, i, j+1, dp)));
    }
}