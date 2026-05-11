class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i=0;i<2*n;i++){
            int idx = i%n;
            while(!stk.isEmpty() && nums[stk.peek()]<nums[idx]){
                result[stk.pop()] = nums[idx];
            }
            if(i<n){
                stk.push(i);
            }
        }
        return result;
    }
}