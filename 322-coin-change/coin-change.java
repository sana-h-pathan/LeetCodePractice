class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m][amount+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        int result = helper(coins, amount, coins.length-1, dp);
        if(result>=(int)1e9){
            return -1;
        }
        return result;
    }
    private int helper(int[] coins, int target, int idx, int[][] dp){
        if(idx==0){
            if(target%coins[idx]==0){
                return target/coins[idx];
            } else {
                return (int)1e9;
            }
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }

        int notTake = helper(coins, target, idx-1, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx]<=target){
            take = 1 + helper(coins, target-coins[idx], idx, dp);
        }
        return dp[idx][target] = Math.min(take, notTake);
    }

    public int coinChange2(int[] coins, int amount) {
        int result = helper(coins, amount, coins.length-1);
        if(result>=(int)1e9){
            return -1;
        }
        return result;
    }
    private int helper(int[] coins, int target, int idx){
        if(idx==0){
            if(target%coins[idx]==0){
                return target/coins[idx];
            } else {
                return (int)1e9;
            }
        }

        int notTake = helper(coins, target, idx-1);
        int take = Integer.MAX_VALUE;
        if(coins[idx]<=target){
            take = 1 + helper(coins, target-coins[idx], idx);
        }
        return Math.min(take, notTake);
    }
}