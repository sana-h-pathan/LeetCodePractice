class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return nums[0];
        if (n == 2) 
            return Math.max(nums[0], nums[1]);

        int first = helper(nums, 0, n - 1); 
        int second = helper(nums, 1, n);
        return Math.max(first, second);
    }

    public int helper(int[] nums, int start, int end) {
        int n = nums.length-1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[n - 1];
    }

    public int rob1(int[] nums) {
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