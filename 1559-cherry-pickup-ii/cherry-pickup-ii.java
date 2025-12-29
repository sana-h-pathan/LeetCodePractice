class Solution {
    int dir[] = {-1, 0, 1};
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2){
                    dp[m-1][j1][j2] = grid[m-1][j1];
                } else{
                    dp[m-1][j1][j2] = grid[m-1][j1]+grid[m-1][j2];
                }
            }
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int maxValue = (int) -1e9;

                    for (int d1 = 0; d1 < 3; d1++) {
                        for (int d2 = 0; d2 < 3; d2++) {

                            int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

                            int nj1 = j1 + dir[d1];
                            int nj2 = j2 + dir[d2];

                            int next = (nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n)
                                    ? dp[i + 1][nj1][nj2]     // <-- MUST be i+1
                                    : (int) -1e9;

                            maxValue = Math.max(maxValue, cherries + next);
                        }
                    }

                    dp[i][j1][j2] = maxValue;
                }
            }
        }

        return dp[0][0][n-1];
    }


    public int cherryPickup1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(grid, 0, 0, n-1, dp);
    }
    private int helper(int[][] grid, int i, int j1, int j2, int[][][] dp){
        if(j1<0 || j1>grid[0].length-1|| j2<0 || j2>grid[0].length-1)
            return (int)-1e9;
        if(i==grid.length-1){
            if(j1==j2){
                return grid[i][j1];
            } else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int maxValue = (int)-1e9;
        for(int d1=0;d1<dir.length;d1++){
            for(int d2=0;d2<dir.length;d2++){
                maxValue = Math.max(maxValue, helper(grid, i+1, j1+dir[d1], j2+dir[d2], dp));
            }
        }
        if(j1==j2){
            maxValue+=grid[i][j1];
        } else{
            maxValue += grid[i][j1]+ grid[i][j2];
        }
        dp[i][j1][j2] = maxValue;
        return dp[i][j1][j2];
    }

    public int cherryPickup2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return helper(grid, 0, 0, n-1);
    }
    private int helper(int[][] grid, int i, int j1, int j2){
        if(j1<0 || j1>grid[0].length-1|| j2<0 || j2>grid[0].length-1)
            return (int)-1e9;
        if(i==grid.length-1){
            if(j1==j2){
                return grid[i][j1];
            } else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int maxValue = (int)-1e9;
        for(int d1=0;d1<dir.length;d1++){
            for(int d2=0;d2<dir.length;d2++){
                maxValue = Math.max(maxValue, helper(grid, i+1, j1+dir[d1], j2+dir[d2]));
            }
        }
        if(j1==j2){
            maxValue+=grid[i][j1];
        } else{
            maxValue += grid[i][j1]+ grid[i][j2];
        }
        return maxValue;
    }
}