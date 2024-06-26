class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<n;i++)
            dp[0][i]=grid[0][i];
        
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){     
                if(j==m-1)
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + grid[i][j]; 
                else if(j==0)
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + grid[i][j]; 
                else              
                    dp[i][j]=grid[i][j]+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i-1][j+1]));
            }
        }
        int min=dp[m-1][0];
        for(int i=1;i<n;i++){
            min=Math.min(dp[m-1][i],min);
        }
        return min;
    }
}