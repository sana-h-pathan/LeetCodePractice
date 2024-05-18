class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > (long) n) 
            return -1;
        int low=0;
        int high=0;
        for(int num: bloomDay){
            low=Math.min(low, num);
            high=Math.max(high, num);
        }
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(isPossible(bloomDay,mid,m,k))
                high = mid-1;
            else 
                low = mid+1;
        }
        return low;
        
    }

    boolean isPossible(int[] bloomDay, int mid, int m, int k) {
        int cnt=0 , curr=0;
        for(int i=0 ; i<bloomDay.length ; i++) {
            if(mid >= bloomDay[i]) {
                curr++;
            }
            else {
                cnt += curr/k;
                curr = 0;
            }
        }
        cnt += curr/k;
        return cnt>=m;
    }
}