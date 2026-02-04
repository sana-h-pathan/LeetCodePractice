class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int currPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            int currProfit = prices[i]-currPrice;
            maxProfit = Math.max(currProfit, maxProfit);
            currPrice = Math.min(currPrice, prices[i]);
        }
        return maxProfit;
    }
}