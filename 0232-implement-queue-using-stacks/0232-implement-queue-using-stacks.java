class MyQueue {

    //create a two stack private because no one can access. 
    private Stack<Integer> frist;
    private Stack<Integer> second;

   
    public MyQueue() {
      frist = new Stack<>();
      second = new Stack<>(); 
    }
    
    public void push(int x) {
       while(!frist.isEmpty()){
            second.push(frist.pop());
        }
        
       frist.push(x);
        
         while(!second.isEmpty()){
            frist.push(second.pop());
        }
    }
    
    public int pop() {
     return  frist.pop();
    }
    
    public int peek() {
        return frist.peek();

    }
    
    public boolean empty() {
        return frist.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */