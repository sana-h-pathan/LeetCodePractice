class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix[0].length;
        int m = matrix.length;
        int minValue = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1000);
        }
        for(int j = 0;j<n;j++){
            minValue = Math.min(helper(matrix, m-1, j, dp), minValue);
        }
        return minValue;
    }
    private int helper(int[][] matrix, int i, int j, int[][] dp){
        if (j < 0 || j >= matrix[0].length) 
            return (int) 1e9;
        if (i == 0) 
            return matrix[0][j];

        if (dp[i][j] != -1000) 
            return dp[i][j];

        int up      = matrix[i][j] + helper(matrix, i - 1, j, dp);
        int upLeft  = matrix[i][j] + helper(matrix, i - 1, j - 1, dp);
        int upRight = matrix[i][j] + helper(matrix, i - 1, j + 1, dp);

        dp[i][j] = Math.min(up, Math.min(upLeft, upRight));
        return dp[i][j];
    }


    public int minFallingPathSum1(int[][] matrix) {
        int n= matrix[0].length;
        int m = matrix.length;
        int minValue = Integer.MAX_VALUE;
        for(int j =0;j<n;j++){
            minValue = Math.min(helper1(matrix, m-1, j), minValue);
        }
        return minValue;
    }
    private int helper1(int[][] matrix, int i, int j){
        if (j < 0 || j >= matrix[0].length) 
            return (int) 1e9;
        if (i == 0) 
            return matrix[0][j];

        int up      = matrix[i][j] + helper1(matrix, i - 1, j);
        int upLeft  = matrix[i][j] + helper1(matrix, i - 1, j - 1);
        int upRight = matrix[i][j] + helper1(matrix, i - 1, j + 1);
        return  Math.min(up, Math.min(upLeft, upRight));
        
    }
}