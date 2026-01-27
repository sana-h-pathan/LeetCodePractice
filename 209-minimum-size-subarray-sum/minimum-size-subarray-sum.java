class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=0;
        int sum=0;
        int minLength=Integer.MAX_VALUE;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>=target){
                sum-=nums[l];
                minLength = Math.min(minLength, r-l+1);
                l++;
            }
            r++;
        }
        return minLength==Integer.MAX_VALUE? 0: minLength;
    }
}