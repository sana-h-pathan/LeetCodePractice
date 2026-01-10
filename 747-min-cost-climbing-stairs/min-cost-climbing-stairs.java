class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0, dp), helper(cost, 1,dp));
    }

    private int helper(int[] cost, int idx, int[] dp) {
        if (idx >= cost.length) {
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        return dp[idx] = cost[idx] + Math.min(
            helper(cost, idx + 1, dp),
            helper(cost, idx + 2, dp)
        );
    }

}