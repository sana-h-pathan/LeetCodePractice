class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums, 0, -1,dp);
    }
    private int helper(int[] nums, int idx, int prevIdx, int[][] dp){
        if(idx==nums.length)
            return 0;
        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }
        int notTake=helper(nums,idx+1, prevIdx,dp);
        int take=0;
        if(prevIdx==-1 || nums[idx]>nums[prevIdx])
            take=1+helper(nums,idx+1, idx,dp);
        dp[idx][prevIdx + 1] =Math.max(take,notTake);
        
        return dp[idx][prevIdx + 1];
    }
    
    public int lengthOfLIS1(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        return dp[n][n+1];
        
    }
    
    
}