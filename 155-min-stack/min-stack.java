class MinStack {
    Stack<Integer> minStk;
    Stack<Integer> stk;
    int minVal;

    public MinStack() {
        this.stk = new Stack<>();
        this.minStk = new Stack<>();
        this.minVal = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        stk.push(value);
        minVal = Math.min(minVal, value);
        minStk.push(minVal);
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
        minVal = minStk.isEmpty()?Integer.MAX_VALUE:minStk.peek();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minVal;
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