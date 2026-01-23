class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=0;i<temperatures.length;i++){
            while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i]){
                int idx = stk.pop();
                result[idx] = i-idx;
            }
            stk.push(i);
        }
        return result;
    }
}