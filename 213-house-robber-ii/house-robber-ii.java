class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        int first = helper(nums,0);
        int second = helper(nums,1);
        return Math.max(first, second);
    }
    private int helper(int[] nums, int s){
        int n = nums.length-1;
        int[] dp = new int[n];
        dp[0] = nums[s];
        dp[1] = Math.max(dp[0], nums[s+1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], nums[s+i]+dp[i-2]);
        } 
        return dp[n-1];
    }
}