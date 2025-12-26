class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) 
            return 0;

        int[][] dp = new int[n][4]; 
        for (int task = 0; task < 4; task++) {
            int minVal = Integer.MAX_VALUE;
            for (int color = 0; color < 3; color++) {
                if (color != task) {
                    minVal = Math.min(minVal, costs[0][color]);
                }
            }
            dp[0][task] = minVal;
        }
        for (int idx = 1; idx < n; idx++) {
            for (int task = 0; task < 4; task++) {
                int minVal = Integer.MAX_VALUE;
                for (int color = 0; color < 3; color++) {
                    if (color != task) {
                        int currVal = costs[idx][color] + dp[idx - 1][color];
                        minVal = Math.min(minVal, currVal);
                    }
                }
                dp[idx][task] = minVal;
            }
        }
        return dp[n - 1][3];
    }
}
