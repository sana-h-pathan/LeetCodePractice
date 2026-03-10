class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p: piles){
            high = Math.max(high, p);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int hrs = countHrs(piles, mid);
            if(hrs>h){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private int countHrs(int[] piles, int h){
        int count = 0;
        for(int p : piles){
            count+=p/h;
            if(p%h!=0){
                count++;
            }
        }
        
        return count;
    }
}