class Solution {
    public int[] getAverages(int[] nums, int k) {
       int n=nums.length;
       int[] res= new int[n];
       Arrays.fill(res,-1);
       if(2*k+1 > n)return res;

       long sum=0;

       for(int i=0;i<=k+k;i++){
        sum+=nums[i];
       }
       int idx=k;
       int d=k+k+1;
       res[idx++]=(int)(sum/d);

       for(int i=k+k+1;i<n;i++){
         sum+=nums[i]-nums[i-d];
         res[idx++]=(int)(sum/d);
       }
       return res;
    }
}