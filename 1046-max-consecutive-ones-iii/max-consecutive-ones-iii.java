class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int l=0;
        int r=0;
        int zeros=0;
        int maxLength=0;
        while(r<nums.length){
            if(nums[r]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}