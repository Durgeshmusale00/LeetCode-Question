class Solution {
    private boolean flag = true;
    public boolean isBipartite(int[][] graph) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

      for(int i = 0;i<graph.length;i++){
        for(int j = 0;j<graph[i].length;j++){
            int e = graph[i][j];

            adj.get(i).add(e);
            adj.get(e).add(i); 
        }
      } 

      int[] vis = new int[graph.length];
      for(int i = 0;i<vis.length;i++){
        if(vis[i] == 0){
            vis[i]=1;
            helper(i, adj, vis);
        }
      }
      return flag;
    }

    public void helper(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        // if(vis[node] != 0){
        //     flag = false;
        //     return;
        // }
        // vis[node] = 2;

        for(int cnd : adj.get(node)){
           if(vis[cnd] == 0){
            if(vis[node] == 1){
                vis[cnd] = 2;
            }else{
                vis[cnd] = 1;
            }
            helper(cnd, adj, vis);
           }else if(vis[node] == vis[cnd]){
            flag = false;
            return;
           }
        }
    }
}