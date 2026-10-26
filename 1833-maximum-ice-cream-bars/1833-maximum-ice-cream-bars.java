class Solution {
    public int maxIceCream(int[] costs, int coins) {
     Arrays.sort(costs);
     int n = costs.length;
     int ans = 0;
     for(int i = 0;i<n;i++){
        if(costs[i] > coins){
            continue;
        }
        if(coins >= costs[i]){
            coins-=costs[i];
            ans++;
        }
     }   
     return ans;
    }
}