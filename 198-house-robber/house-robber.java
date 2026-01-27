class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        if(nums.length==1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }

    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    private int helper(int[] nums, int idx, int[] dp){
        if(idx==nums.length-1){
            return nums[idx];
        }
        if(idx==nums.length)
            return 0;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int notPick = helper(nums, idx+1);
        int pick = nums[idx]+ helper(nums, idx+2);
        dp[idx] = Math.max(pick, notPick);
        return dp[idx];
    }

    public int rob2(int[] nums) {
        return helper(nums, 0);
    }
    private int helper(int[] nums, int idx){
        if(idx==nums.length-1){
            return nums[idx];
        }
        if(idx==nums.length)
            return 0;
        int notPick = helper(nums, idx+1);
        int pick = nums[idx]+ helper(nums, idx+2);
        return Math.max(pick, notPick);
    }
}