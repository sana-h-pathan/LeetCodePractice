class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    int min;
    public MinStack() {
        this.stk=new Stack<>();
        this.minStk=new Stack<>();
        this.min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min=Integer.min(min,val);
        stk.push(val);
        minStk.push(min);
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
        min=minStk.size()==0?Integer.MAX_VALUE:minStk.peek();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.size()==0?Integer.MAX_VALUE:minStk.peek();
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