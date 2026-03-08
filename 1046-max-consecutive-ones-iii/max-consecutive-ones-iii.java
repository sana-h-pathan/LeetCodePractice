class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zeroCnt = 0;
        int maxLength=0;
        while(r<nums.length){
            if(nums[r]==0){
                zeroCnt++;
            }
            while(zeroCnt>k){
                if(nums[l]==0){
                    zeroCnt--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}