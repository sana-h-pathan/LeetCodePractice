class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=0;
        for(int j=1;j<=n;j++){
            dp[0][j]=amount+1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int coinDeno=coins[i-1];
                if(j<coinDeno){
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(1+dp[i][j-coinDeno],dp[i-1][j]);
                }
            }
        }
        if(dp[m][n]==amount+1)
            return -1;
        return dp[m][n];
    }
}