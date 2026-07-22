class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        int left = nums.length; // changed
        int right = 0;          // changed

        // Find the left boundary
        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                left = Math.min(left, stk.pop()); // changed
            }
            stk.push(i);
        }

        stk.clear();

        // Find the right boundary
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                right = Math.max(right, stk.pop()); // changed
            }
            stk.push(i);
        }

        return right > left ? right - left + 1 : 0; // changed
    }
}