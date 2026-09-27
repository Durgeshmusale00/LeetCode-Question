class Solution { 
    public int climbStairs(int n) {
      int[] memo = new int[n+1];
      int ans = fibo(n, memo);
      return ans;  
    }
    public static int fibo(int n, int[] memo){
	if(n <= 2){
	        return memo[n] = n;
	    }
	    if(memo[n] != 0){
	        return memo[n];
	    }
	    
	    return memo[n] = fibo(n-1, memo) + fibo(n-2, memo);
	}
}