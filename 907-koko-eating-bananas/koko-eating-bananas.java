class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile: piles){
            high = Math.max(high, pile);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int totalHours = countHours(piles, mid);
            if(totalHours<=h){
                high=mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private int countHours(int[] piles, int n){
        int totalHours=0;
        for(int pile: piles){
            totalHours+=pile/n;
            if(pile%n!=0)
                totalHours++;
        }
        return totalHours;
    }
}