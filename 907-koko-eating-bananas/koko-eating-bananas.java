class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Integer.max(high,piles[i]);
        }
        if(piles.length==h)
            return high;
        while(low<high){
            int mid=low+(high-low)/2;
            int reqdHour=calculateDuration(piles,mid);
            if(reqdHour<=h){
                high=mid;
            }
            else 
                low=mid+1;
        }
        return low;
    }
    private int calculateDuration(int[] piles, int mid){
        int hours=0;
        for(int i:piles){
            int time=i/mid;
            hours+=time;
            if(i%mid!=0) 
            hours++;
        }
        return hours;
    }
}
