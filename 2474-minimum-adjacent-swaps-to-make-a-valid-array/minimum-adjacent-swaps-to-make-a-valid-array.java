class Solution {
    public int minimumSwaps(int[] nums) {
        int minIdx=0;
        int min=Integer.MAX_VALUE;
        int maxIdx=0;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                minIdx=i;
            }
            if(nums[i]>=max){
                max=nums[i];
                maxIdx=i;
            }
        }
        int minSwap=minIdx;
        int maxSwap=n-(maxIdx+1);
        if(minIdx>maxIdx)
            return minSwap+maxSwap-1;
        return minSwap+maxSwap;
    }
}