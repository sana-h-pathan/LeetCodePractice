package practice.easy;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice=prices[0];
        for (int i=0;i<prices.length;i++){
            int profit=prices[i]-minPrice;
            maxProfit= Integer.max(maxProfit,profit);
            minPrice=Integer.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        MaxProfit maxProfit=new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
