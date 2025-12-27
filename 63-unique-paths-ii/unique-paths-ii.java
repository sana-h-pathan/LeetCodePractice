class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dp[i][j]=0;
                } else if(i==0 && j==0){
                    dp[i][j]=1;
                } else{
                    int up=0;
                    int left = 0;
                    if(i>0){
                        up= dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
        
    public int uniquePathsWithObstacles2(int[][] grid) {
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

    public int uniquePathsWithObstacles1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return helper1(grid, m-1, n-1);
    }
    private int helper1(int[][] grid, int i, int j){
        if(i>=0 && j>=0 && grid[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0)
            return 0;
        
        int up = helper1(grid, i-1, j);
        int left = helper1(grid, i, j-1);
        return up+left;
    }
}