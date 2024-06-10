class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=n;i++)
            dp[0][i]=amount+1;
        dp[0][0]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int coinVal=coins[i-1];
                if(j<coinVal)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coinVal]);
            }
        }
        if(dp[m][n]>amount)
            return -1;
        return dp[m][n];
    }
}