class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return nums[0];
        if (n == 2) 
            return Math.max(nums[0], nums[1]);
        
        int first = helper(nums, 0, n-2);
        int second = helper(nums, 1, n-1);
        return Math.max(first, second);
    }
    private int helper(int[] nums, int start, int end){
        int n =nums.length-1;
        int[] dp = new int[n];
        
        dp[0]=nums[start];
        dp[1] = Math.max(nums[start+1], dp[0]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+nums[start+i], dp[i-1]);
        }
        return dp[n-1];
    }
}