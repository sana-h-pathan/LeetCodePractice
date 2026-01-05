class Solution {
    private int m, n;
    private int maxSide = 0;
    int[][] dirs = new int[][]{{1,0},{0,1},{1,1}};
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; 
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j],
                                   Math.min(dp[i][j-1], dp[i-1][j-1]));
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxSide * maxSide;
    }


    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0;

        this.m = matrix.length;
        this.n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(matrix, i, j, dp);
            }
        }
        return maxSide * maxSide;
    }

    private int solve(char[][] matrix, int i, int j, int[][] dp) {
        // Out of bounds
        if (i >= m || j >= n) 
            return 0;
        // If cell is '0', no square can start here
        if (matrix[i][j] == '0') {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int minVal=Integer.MAX_VALUE;
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            minVal = Math.min(minVal, solve(matrix, nr, nc, dp));
        }
        maxSide = Math.max(maxSide, 1 + minVal);
        dp[i][j]=1 + minVal;
        return dp[i][j];
    }


    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0;

        this.m = matrix.length;
        this.n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(matrix, i, j);
            }
        }
        return maxSide * maxSide;
    }

    private int solve(char[][] matrix, int i, int j) {
        // Out of bounds
        if (i >= m || j >= n) 
            return 0;
        // If cell is '0', no square can start here
        if (matrix[i][j] == '0') {
            return 0;
        }
        int minVal=Integer.MAX_VALUE;
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            minVal = Math.min(minVal, solve(matrix, nr, nc));
        }
        maxSide = Math.max(maxSide, 1 + minVal);
        return 1 + minVal;
    }

}
