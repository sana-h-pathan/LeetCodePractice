class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w: weights){
            low=Math.max(low, w);
            high+=w;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int requiredDays=calculate(weights, mid);
            if(requiredDays>days)
                low=mid+1;
            else
                high=mid-1;

        }
        return low;
    }

    private int calculate(int[] nums, int capacity) {
        int count = 1;
        int currSum = 0;

        for (int num : nums) {
            if (currSum + num <= capacity) {
                currSum += num;
            } else {
                count++;
                currSum = num;
            }
        }
        return count;
    }
}