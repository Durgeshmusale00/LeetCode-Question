class Solution {
    public int smallestNumber(int n, int t) {
      int product = 1;
      for(int i = n; i<=100;i++){
      int tcopy = i;
      while(tcopy != 0){
        int temp = tcopy % 10;
        product = product * temp;
        tcopy = tcopy / 10;
      }
      if(product % t == 0){
        return i;
      } else{
        product = 1;
      }
      }
      return 0; 
    }
}