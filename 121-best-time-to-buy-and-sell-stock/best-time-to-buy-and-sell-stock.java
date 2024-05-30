class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice=prices[0];
        for (int i=1;i<prices.length;i++){
            int profit=prices[i]-minPrice;
            maxProfit= Integer.max(maxProfit,profit);
            minPrice=Integer.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}

