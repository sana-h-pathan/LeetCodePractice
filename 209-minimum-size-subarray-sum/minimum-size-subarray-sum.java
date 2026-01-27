class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r=0;
        int l=0;
        int currSum = 0;
        int result = Integer.MAX_VALUE;
        while(r<nums.length){
            currSum+=nums[r];
            while(currSum>=target){
                result = Math.min(result, r-l+1);
                currSum-=nums[l];
                l++;
            }
            r++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}