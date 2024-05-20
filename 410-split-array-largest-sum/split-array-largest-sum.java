class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (n<k) 
            return -1;
        int low = 0;
        int high = 0;
        for (int num: nums) {
            low=Math.max(low, num);
            high+=num;
        }
        int minVal=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=calculate(nums, mid);
            if(count>k)
                low=mid+1;
            else
                high=mid-1;

        }

        return Math.max(high,minVal);
    }
    private int calculate(int[] nums, int capacity){
        int count=1;
        int temp=capacity;
        for(int i=0;i<nums.length;i++){
            if(temp-nums[i]>0){
                temp=temp-nums[i];
            }
            else{
                temp=capacity;
                temp=temp-nums[i];
                count++;
            }
        }
        return count;
    }
}