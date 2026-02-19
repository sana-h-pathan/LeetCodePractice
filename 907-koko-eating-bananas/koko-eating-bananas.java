class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p: piles){
            high = Math.max(p, high);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int hrsReq = countHrs(piles, mid);
            if(hrsReq>h){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int countHrs(int[] piles, int n){
        int count = 0;
        for(int p: piles){
            count+=p/n;
            if(p%n!=0){
                count++;
            }
        }
        return count;
    }
}