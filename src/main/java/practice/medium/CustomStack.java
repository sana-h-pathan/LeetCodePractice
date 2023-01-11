package practice.medium;

public class CustomStack {
    int[] customStack;
    int i;
    int max;
    public CustomStack(int maxSize) {
        this.customStack = new int[maxSize];
        this.i=0;
        this.max = maxSize;
    }

    public void push(int x) {
        if(i < 0 )
            i=0;
        if(i < max ){
            customStack[i] = x;
            i++;
        }
    }
    public int pop() {
        i--;
        if(i < 0)
            return -1;
        return customStack[i];
    }
    public void increment(int k, int val) {
        if(k > max)
            k = max;
        for(int j=0; j<k; j++)
            customStack[j] += val;
    }

    public static void main(String[] args) {
        CustomStack stk=new CustomStack(3);
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        System.out.println(stk.pop());
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);
    }
}
