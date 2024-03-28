class Solution {
    public int minimumSwaps(int[] nums) {
        int minNum=Integer.MAX_VALUE;
        int maxNumber=Integer.MIN_VALUE;
        int minIdx=0;
        int maxIdx=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<minNum){
                minNum=nums[i];
                minIdx=i;
            }
            if(nums[i]>=maxNumber){
                maxNumber=nums[i];
                maxIdx=i;
            }
        }
        if(minIdx>maxIdx)
            return (n-maxIdx-1)+minIdx-1;

        return (n-maxIdx-1)+minIdx;
    }
}