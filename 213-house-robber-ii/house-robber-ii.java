class Solution {
    

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return nums[0];

        int first = robRange(nums, 0, n - 2);
        int second = robRange(nums, 1, n - 1);

        return Math.max(first, second);
    }

    private int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, start, end, dp);
    }

    private int helper(int[] nums, int i, int end, int[] dp) {
        if (i > end) 
            return 0;
        if(dp[i]!=-1)
            return dp[i];

        // choose: rob i, skip i+1
        int take = nums[i] + helper(nums, i + 2, end, dp);

        // not choose: skip i
        int skip = helper(nums, i + 1, end, dp);

        return dp[i] = Math.max(take, skip);
    }

    

    
}