class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        helper(grid, m-1, n-1, dp);
        return dp[m-1][n-1];
    }

    private int helper(int[][] grid, int i, int j, int[][] dp ){
        if(i==0 && j==0){
            dp[0][0] = grid[0][0];
            return dp[0][0];
        }
        if(i<0 || j<0){
            return (int)1e9;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left = grid[i][j]+helper(grid, i, j-1, dp);
        int up = grid[i][j]+helper(grid, i-1, j, dp);
        dp[i][j] = Math.min(left, up);
        return dp[i][j];
    }
}