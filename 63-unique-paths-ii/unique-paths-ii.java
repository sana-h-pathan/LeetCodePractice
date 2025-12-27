class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(grid, m-1, n-1, dp);
    }
    private int helper(int[][] grid, int i, int j, int[][] dp){
        if(i>=0 && j>=0 && grid[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up = helper(grid, i-1, j, dp);
        int left = helper(grid, i, j-1, dp);
        dp[i][j]=up+left;
        return dp[i][j];
    }
}