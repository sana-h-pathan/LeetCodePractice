class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(costs, n-1, 3, dp);
    }

    private int helper(int[][] costs, int idx, int task, int[][] dp){
        if(idx==0){
            int minVal = Integer.MAX_VALUE;
            for(int i=0;i<=2;i++){
                if(i!=task){
                    minVal = Math.min(minVal, costs[0][i]);
                }
            }
            return minVal;
        }
        if(dp[idx][task]!=-1)
            return dp[idx][task];
        int minVal = Integer.MAX_VALUE;
        for(int i=0;i<=2;i++){
            if(i!=task){
                int currVal = costs[idx][i] + helper(costs, idx-1, i, dp);
                minVal = Math.min(minVal, currVal);
            }
        }
        dp[idx][task]=minVal;
        return dp[idx][task];
    }
}