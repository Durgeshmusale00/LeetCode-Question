class Solution {
    public int maxNumberOfFamilies(int n, int[][] rS) {
     HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
      for (int[] pair : rS) {
        map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
      }
     int result = (n - map.size()) * 2;
      
      for(int row : map.keySet()){
            boolean GroupA = isSafe(map, row, 2) && isSafe(map, row, 3) && isSafe(map, row, 4) && isSafe(map, row, 5);
            boolean GroupB = isSafe(map, row, 4) && isSafe(map, row, 5) && isSafe(map, row, 6) && isSafe(map, row, 7);
            boolean GroupC = isSafe(map, row, 7) && isSafe(map, row, 8) && isSafe(map, row, 9) && isSafe(map, row, 6);
            
            if(GroupA && GroupC){
                result+=2;
            }else if(GroupA || GroupB || GroupC){
                result+=1;
            }
        }
      return result;
        
    }
   
   public boolean isSafe(HashMap <Integer, ArrayList<Integer>> map, int row, int target){
      return !map.get(row).contains(target);
   }
}