class Solution {

      class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      Queue<Pair> q = new LinkedList<>();
      //adding all place where 2 store.
      for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(grid[i][j] == 2){
                q.add(new Pair(i, j));
            }
        }
      } 

      int[] dx = {-1, 0, 1, 0};
      int[] dy = {0, 1, 0, -1};
      int ans = 0;
      while(!q.isEmpty()){
        int sz = q.size();
        for(int i = 0;i<sz;i++){
         Pair p = q.poll();
         int x = p.x;
         int y = p.y;

         for(int j = 0;j<4;j++){
            int nx = x + dx[j];
            int ny = y + dy[j];

            if((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && (grid[nx][ny] == 1)){
                grid[nx][ny] = 2;
                q.add(new Pair(nx, ny));
            }
         }
        }
        if(!q.isEmpty()){
            ans++;
        }
      } 

      for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(grid[i][j] == 1){
                return -1;
            }
        }
      } 
      return ans;
    }
}