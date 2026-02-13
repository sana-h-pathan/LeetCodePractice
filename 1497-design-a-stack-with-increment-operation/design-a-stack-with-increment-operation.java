class CustomStack {
    int[] customStack;
    int count;
    int capacity;

    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        this.customStack = new int[capacity];
        this.count=0;
    }
    
    public void push(int x) {
        if(count<capacity){
            customStack[count] = x;
            count++;
        }
    }
    
    public int pop() {
        if(count==0){
            return -1;
        }
        count--;
        return customStack[count];
    }
    
    public void increment(int k, int val) {
        if(k>count){
            k=count;
        }
        for(int i=0;i<k;i++){
            customStack[i]+=val;
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