class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSum(nums,goal)-findSum(nums, goal-1);
    }

    private int findSum(int[] nums, int k){
        if(k<0)
            return 0;
        int l=0;
        int r=0;
        int result=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            result+=r-l+1;
            r++;
        }
        return result;
    }
}