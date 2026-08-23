class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        for(int i = 0;i<strs[0].length();i++){
        char ch = strs[0].charAt(i);
        boolean flag = true;
            for(int j = 1;j<strs.length;j++){
                if(strs[j].length() >= i + 1 && strs[j].charAt(i) == ch){
                    continue;
                }else{
                    flag = false;
                    break;
                }
              } 
              if(flag){
                str+=ch;
              }else{
                return str;
              }
            }  
            if(str.length() <= 0){
        return "";
            }else{
                return str;   
            }
       
        }
    } 
