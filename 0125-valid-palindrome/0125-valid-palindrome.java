class Solution {
    public boolean isPalindrome(String s) {
     s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    //  System.out.print(s);
      int l = 0;
      int e = s.length()-1;

      while(l<=e){
        if(s.charAt(l) != s.charAt(e)) {
            return false;
        }
        l++;
        e--; 
      }  
      return true;  
    }
}