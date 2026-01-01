class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n];
        for(int i=0;i<=amount;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(coins, amount, n-1, dp);
    }
    private int helper(int[] coins, int amount, int idx, int[][] dp){
        if(amount==0)
            return 1;
        if(amount<0 || idx<0)
            return 0;
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        int notChoose = helper(coins, amount, idx - 1, dp);
        int choose = helper(coins, amount - coins[idx], idx, dp);

        dp[amount][idx] = notChoose + choose;
        return dp[amount][idx];
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