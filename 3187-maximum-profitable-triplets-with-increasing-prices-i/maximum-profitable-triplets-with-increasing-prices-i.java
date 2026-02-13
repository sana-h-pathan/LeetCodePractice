
class Solution {
  
  public int maxProfit(int[] prices, int[] profits) {

        int len = prices.length;
        int[][] dp = new int[len][3];
        
        int ans=-1;
        for(int i=0; i<len; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][0] = profits[i];

            for(int j=i-1; j>=0; j--){
                if(prices[j] >= prices[i]) continue;

                if(dp[j][0]==Integer.MIN_VALUE) continue;
                dp[i][1] = Math.max(dp[i][1], profits[i] + dp[j][0]);

                if(dp[j][1]==Integer.MIN_VALUE) continue;
                dp[i][2] = Math.max(dp[i][2], profits[i] + dp[j][1]);
                ans = Math.max(ans, dp[i][2]);
            }
        }

        return ans;
    }
}