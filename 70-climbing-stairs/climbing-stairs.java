class Solution {
    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n-1];
    }


    public int climbStairs1(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n,0, dp);
    }
    private int helper(int n, int idx, int[] dp){
        if(idx>n){
            return 0;
        }
        if(idx==n){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        return dp[idx] = helper(n, idx+1, dp) + helper(n, idx+2,dp);
    }



    public int climbStairs2(int n) {
        return helper(n,0);
    }
    private int helper(int n, int idx){
        if(idx>n){
            return 0;
        }
        if(idx==n){
            return 1;
        }
        return helper(n, idx+1) + helper(n, idx+2);
    }
}