class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=0;
        int minLength = Integer.MAX_VALUE;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(target<=sum){
                minLength = Math.min(r-l+1, minLength);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}