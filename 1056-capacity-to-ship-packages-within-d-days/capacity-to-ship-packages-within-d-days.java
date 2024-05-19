class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w: weights){
            low=Math.max(low, w);
            high+=w;
        }
        int minWeight=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            int requiredDays=calculateDays(weights, mid);
            if(requiredDays>days)
                low=mid+1;
            else
                high=mid-1;

        }
        return Math.max(high,minWeight);
    }

    private int calculateDays(int[] weights, int capacity){
        int count=1;
        int temp=capacity;
        for(int i=0;i<weights.length;i++){
            if(temp-weights[i]>0){
                temp=temp-weights[i];
            }
            else{
                temp=capacity;
                temp=temp-weights[i];
                count++;
            }
        }
        return count;
    }
}