class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice=prices[0];
        for(int i=0;i<prices.length;i++){
            int currProfit=prices[i]-minPrice;
            
            minPrice=Integer.min(minPrice, prices[i]);  
            maxProfit=Integer.max(currProfit, maxProfit);
        }
        return maxProfit;
    }
}