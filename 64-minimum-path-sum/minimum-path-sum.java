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


    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                     dp[0][0] = grid[0][0];
                } else {
                    int up=0;
                    int left =0;
                    if(i>0){
                        up = grid[i][j] + dp[i-1][j];
                    }
                    if(j>0){
                        left = grid[i][j] + dp[i][j-1];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
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

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return helper(grid, m-1, n-1);
    }

    private int helper(int[][] grid, int i, int j){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE/2;
        }
        int left = grid[i][j]+helper(grid, i, j-1);
        int up = grid[i][j]+helper(grid, i-1, j);
        return Math.min(left, up);
    }
}