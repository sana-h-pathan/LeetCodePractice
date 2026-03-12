class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n, 0, dp);
    }
    private int helper(int n, int idx, int[] dp){
        if(n<idx){
            return 0;
        }
        if(n==idx){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        dp[idx] = helper(n, idx+1, dp) + helper(n, idx+2, dp);
        return dp[idx];
    }
    public int climbStairs1(int n) {
        return helper(n, 0);
    }
    private int helper(int n, int idx){
        if(n<idx){
            return 0;
        }
        if(n==idx){
            return 1;
        }
        return helper(n, idx+1) + helper(n, idx+2);
    }
}