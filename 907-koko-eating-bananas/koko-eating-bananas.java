class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        int result=0;
        for(int num:piles){
            high=Integer.max(high, num);
        }
        if(piles.length==h)
            return high;
        while(low<high){
            int mid=low+(high-low)/2;
            int reqdhrs=calculateHours(piles,mid);
            if(reqdhrs<=h)
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }

    private int calculateHours(int[] piles, int hrly){
        int totalHrs=0;
        for(int i=0;i<piles.length;i++){
            totalHrs+=piles[i]/hrly;
            if(piles[i]%hrly!=0)
                totalHrs++;
        }
        return totalHrs;
    }
}