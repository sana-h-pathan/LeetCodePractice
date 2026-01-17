class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p: piles){
            high = Math.max(high, p);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int hrs = countHours(piles,mid);
            if(hrs<=h){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    private int countHours(int[] piles, int h){
        int totalHrs = 0;
        for(int p: piles){
            totalHrs+=p/h;
            if(p%h!=0){
                totalHrs++;
            }
        }
        return totalHrs;
    }
}