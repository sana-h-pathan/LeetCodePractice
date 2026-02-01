class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];

        int min1 = Integer.MAX_VALUE; // smallest in nums[1..]
        int min2 = Integer.MAX_VALUE; // 2nd smallest in nums[1..]

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        return first + min1 + min2;
    }
}
