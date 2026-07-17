class MinStack {

    private int[] data;
    private int ptr;

    public MinStack() {
        data = new int[10]; // Initial size
        ptr = 0;
    }

    public void push(int value) {
    if (ptr == data.length) {
    int[] newData = new int[data.length * 2];

    for (int i = 0; i < data.length; i++) {
        newData[i] = data[i];
    }

    data = newData;
    }
        data[ptr++] = value;
    }

    public void pop() {
        if (ptr > 0) {
            ptr--;
        }
    }

    public int top() {
        return data[ptr - 1];
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ptr; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        return min;
    }

    public boolean isFull(){
        return ptr == data.length;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */