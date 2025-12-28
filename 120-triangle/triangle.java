class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j)+ helper(triangle, i+1, j,dp);
                int diagonal = triangle.get(i).get(j)+ helper(triangle, i+1, j+1, dp);
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return helper(triangle, 0, 0, dp);
    }
    private int helper(List<List<Integer>> triangle, int i, int j,  int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j)+ helper(triangle, i+1, j,dp);
        int diagonal = triangle.get(i).get(j)+ helper(triangle, i+1, j+1, dp);
        dp[i][j] = Math.min(down, diagonal);
        return dp[i][j];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }
    private int helper(List<List<Integer>> triangle, int i, int j){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        int down = triangle.get(i).get(j)+ helper(triangle, i+1, j);
        int diagonal = triangle.get(i).get(j)+ helper(triangle, i+1, j+1);
        return Math.min(down, diagonal);

    }
}