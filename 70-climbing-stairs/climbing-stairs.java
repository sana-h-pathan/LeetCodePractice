class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private int helper(int n, int[] dp){
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];

        int step1Count = helper(n-1, dp);
        int step2Count = helper(n-2, dp);
        dp[n]= step1Count+step2Count;
        return dp[n];
    }
}