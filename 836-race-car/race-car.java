class Solution {
    int[] dp = new int[10001];
    public int racecar(int target) {
        Arrays.fill(dp,-1);
        return solve(target);
    }

    public int solve(int target) {
        if(target == 0) return 0;
        if(dp[target] != -1) return dp[target];
        int n = (int)(Math.log(target)/Math.log(2)) + 1;
        if(target + 1 == (1<<n)) { 
            dp[target] = n;
            return n;
        }
        else {
            int minSteps = n + 1 + solve((1<<n)-1-target);
            for(int m = 0;m<n-1;m++) {
                minSteps = Math.min(minSteps, n+m+1+solve(target-(1<<(n-1))+ (1<<m)));
            }
            dp[target] = minSteps;
        }
        return dp[target]; 
    }
}