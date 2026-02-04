class StockSpanner {
    Stack<int[]> stk = new Stack<>();
    
    public int next(int price) {
        int currSpan = 1;
        while (!stk.isEmpty()&& stk.peek()[0]<=price) {
            currSpan += stk.pop()[1];
        }
        
        stk.push(new int[] {price,currSpan});
        return currSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */