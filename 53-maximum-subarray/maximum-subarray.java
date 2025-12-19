class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
    
    public int maxSubArray1(int[] nums) { //this gives the array as well
        int currSum=nums[0];
        int maxSum=nums[0];
        int startIndex=0;
        int endIndex=0;
        int currStart=0;
        for(int i=1;i<nums.length;i++){
            currSum=currSum+nums[i];
            if(currSum<nums[i]){
                currSum=nums[i];
                currStart=i;
            }
            
            if(maxSum<=currSum){
                maxSum=currSum;
                endIndex=i;
                startIndex=currStart;   
            }
        }
        int cnt=endIndex-startIndex;
        int[] result=new int[cnt+1];
        for(int i=0;i<=cnt;i++){
            result[i]=nums[startIndex];
            startIndex++;
        }
        return maxSum;
    }
}