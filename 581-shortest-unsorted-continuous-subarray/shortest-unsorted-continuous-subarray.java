class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int l = nums.length;
        int r = 0;
        for(int i=0;i<nums.length;i++){
            while(!stk.isEmpty() && nums[stk.peek()]>nums[i]){
                l = Math.min(l, stk.pop());
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()]<nums[i]){
                r = Math.max(r, stk.pop());
            }
            stk.push(i);
        }
        return r>l?r-l+1:0;
    }
}