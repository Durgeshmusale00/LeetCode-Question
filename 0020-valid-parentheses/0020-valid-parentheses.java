class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n < 2) return false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            //case for the opennnig bracket.
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            }else{
               if(stack.isEmpty()) return false;

                char top = stack.peek();
            // for the colsing bracket.
              if((ch == ')' && top == '(') || 
                (ch == ']' && top == '[') || 
                (ch == '}' && top == '{')){
                stack.pop();
            }else{
                return false;
            }
            }   
        } 
        return stack.isEmpty();
    }
}