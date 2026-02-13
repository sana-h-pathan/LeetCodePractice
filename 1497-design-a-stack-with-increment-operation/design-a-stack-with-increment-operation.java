class CustomStack {
    int[] customStack;
    int count;
    int max;

    public CustomStack(int maxSize) {
        this.customStack = new int[maxSize];
        this.count = 0;
        this.max = maxSize;
    }

    public void push(int x) {
        if (count < max) {
            customStack[count] = x;
            count++;
        }
    }

    public int pop() {
        if (count == 0) {              
            return -1;                 
        }
        count--;                       
        return customStack[count];
    }

    public void increment(int k, int val) {
        if (k > count) 
            k = count;       
        for (int j = 0; j < k; j++) {
            customStack[j] += val;
        }
    }
}
