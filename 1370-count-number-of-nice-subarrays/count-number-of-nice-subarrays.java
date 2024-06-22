class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findSum(nums, k)-findSum(nums, k-1);
    }
    private int findSum(int[] nums, int k){
        if(k<0)
            return 0;
        int l=0;
        int r=0;
        int sum=0;
        int result=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k){
                sum-=nums[l]%2;
                l++;
            }
            result+=r-l+1;
            r++;
        }
        return result;
    }
}