class Solution {
    public int lengthOfLISBinarySearch(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n=nums.length;
        int length=1;
        int[] effectiveArray=new int[n];
        effectiveArray[0]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>effectiveArray[length-1]){
                effectiveArray[length]=nums[i];
                length++;
            }
            else{
                int bsIdx=binarySearch(effectiveArray,0,length-1,nums[i]);
                effectiveArray[bsIdx]=nums[i];
            }
        }
        return length;
    }
    
    private int binarySearch(int[] effectiveArr, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(effectiveArr[mid]==target)
                return mid;
            else if(effectiveArr[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n=nums.length;
        int maxLIS=1;
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int compareNumber=nums[i];
                if(compareNumber>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxLIS=Math.max(maxLIS, dp[i]);
                }
            }
        }
        return maxLIS;
     }
}