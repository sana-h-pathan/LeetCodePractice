class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    private int helper(int[] nums, int idx, int[] dp){
        if(idx==nums.length-1){
            return nums[idx];
        }
        if(idx>nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick = nums[idx]+helper(nums, idx+2,dp);
        int notPick = 0+helper(nums, idx+1,dp);
        return dp[idx]=Math.max(pick, notPick);
    }


    public int rob2(int[] nums) {
        return helper(nums, 0);
    }
    private int helper(int[] nums, int idx){
        if(idx==nums.length-1){
            return nums[idx];
        }
        if(idx>nums.length-1){
            return 0;
        }
        int pick = nums[idx]+helper(nums, idx+2);
        int notPick = 0+helper(nums, idx+1);
        return Math.max(pick, notPick);
    }
}