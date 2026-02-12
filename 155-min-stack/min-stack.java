class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    int minimum;
    public MinStack() {
        this.stk = new Stack<>();
        this.minStk = new Stack<>();
        this.minimum = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stk.push(val);
        minimum = Math.min(minimum, val);
        minStk.push(minimum);
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
        minimum = minStk.isEmpty()? Integer.MAX_VALUE:minStk.peek();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */