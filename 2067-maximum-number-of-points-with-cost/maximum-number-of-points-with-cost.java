class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = points[0][i];
        }
        
        for (int r = 1; r < m; r++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] newDp = new long[n];
            
            leftMax[0] = dp[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i-1], dp[i] + i);
            }
            
            rightMax[n-1] = dp[n-1] - (n-1);
            for (int i = n-2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i+1], dp[i] - i);
            }
            
            for (int i = 0; i < n; i++) {
                newDp[i] = Math.max(leftMax[i] - i, rightMax[i] + i) + points[r][i];
            }
            
            dp = newDp;
        }
        
        long result = Long.MIN_VALUE;
        for (long value : dp) {
            result = Math.max(result, value);
        }
        
        return result;
    }
}