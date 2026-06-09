class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p: piles){
            high = Math.max(p, high);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int hrs = countHours(piles, mid);
            if(hrs>h){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countHours(int[] piles, int hrs){
        int count = 0;
        for(int p: piles){
            count+=p/hrs;
            if(p%hrs!=0){
                count++;
            }
        }
        return count;
    }
}