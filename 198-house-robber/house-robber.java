class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, n-1, dp);
    }

    private int helper(int[] nums, int idx, int[] dp){
        if(idx==0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int firstHouse = nums[idx]+helper(nums, idx-2, dp);
        int secondHouse = helper(nums, idx-1, dp);
        dp[idx] = Math.max(firstHouse, secondHouse);
        return dp[idx];
    }

    public int rob2(int[] nums) {
        return helper2(nums, nums.length-1);
    }

    private int helper2(int[] nums, int idx){
        if(idx==0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }
        int pick = nums[idx] + helper2(nums, idx-2);
        int notPick = 0 + helper2(nums, idx-1);
        return Math.max(pick, notPick);
    }
}