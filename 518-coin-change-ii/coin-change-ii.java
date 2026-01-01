class Solution {
    
    public int change1(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];
        for(int i=1;i<=m;i++){
            Arrays.fill(dp[i], -1);
        }
        return 0;
    }

    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(coins, amount, m-1, dp);
    }
    private int helper(int[] coins, int amount, int idx, int[][] dp){
        if(amount==0)
            return 1;
        if(amount<0 || idx<0)
            return 0;
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int notChoose = helper(coins, amount, idx - 1, dp);
        int choose = helper(coins, amount - coins[idx], idx, dp);

        dp[idx][amount] = notChoose + choose;
        return dp[idx][amount];
    }

    public int change2(int amount, int[] coins) {
        int n = coins.length;
        return helper(coins, amount, n-1);
    }
    private int helper(int[] coins, int amount, int idx){
        if(amount==0)
            return 1;
        if(amount<0 || idx<0)
            return 0;
        
        int notChoose = helper(coins, amount, idx - 1);
        int choose = helper(coins, amount - coins[idx], idx);

        return notChoose + choose;
    }
}