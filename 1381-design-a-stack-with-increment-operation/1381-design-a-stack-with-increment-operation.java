class CustomStack {
    private Stack<Integer> st;
    private int sz;

    public CustomStack(int maxSize) {
        st = new Stack<>();
        sz = maxSize;
    }
    
    public void push(int x) {
        if(st.size()  < sz){
            st.push(x);
        }
    }
    
    public int pop() {
        if(!st.isEmpty()){
            return st.remove(st.size()-1);
        }
        return -1;
    }
    
   public void increment(int k, int val) {
        int limit = Math.min(k, st.size());
        for (int i = 0; i < limit; i++) {
            st.set(i, st.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */