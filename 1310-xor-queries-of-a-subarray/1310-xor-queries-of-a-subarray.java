class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
           prefix[i] = prefix[i-1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];

            if(s == 0){
               ans[i] = prefix[e]; 
            }else{
                ans[i] = prefix[e] ^ prefix[s - 1];
            }
        }

        return ans;
    }
}