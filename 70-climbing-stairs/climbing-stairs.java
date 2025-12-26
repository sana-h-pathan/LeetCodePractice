class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        int first = climbStairs1(n-1);
        int second = climbStairs1(n-2);
        return first+second;
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n+1];
        return helper(n, dp);
    }
    private int helper(int n, int[] dp){
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        dp[n] = helper(n-1, dp) + helper(n-2, dp);
        return dp[n];
    }
}