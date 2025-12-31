class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int n = nums.length;
        for(int num: nums){
            target+=num;
        }
        if(target%2!=0){
            return false;
        }
        target = target/2;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return subsetSumToK(nums, nums.length, target);
    }
    private boolean subsetSumToK(int[] nums,int n, int target){
        boolean[][] dp = new boolean[n][target+1];
        // sum = 0 is always possible (pick nothing)
        for (int i = 0; i < n; i++) 
            dp[i][0] = true;

        // base for first element
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i]<=j){
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][target];
    }


    private boolean helper1(int[] nums, int idx, int target, int[][] dp){
        if(target==0){
            return true;
        }
        if(idx==0){
            return nums[0]==target;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        boolean notTake = helper1(nums, idx-1, target, dp);
        boolean take = false;
        if(nums[idx]<target){
            take = helper1(nums, idx-1, target-nums[idx], dp);
        }
        dp[idx][target] = take || notTake? 1:0;
        return dp[idx][target]==1;
    }


    private boolean helper2(int[] nums, int idx, int target){
        if(target==0){
            return true;
        }
        if(idx==0){
            return nums[0]==target;
        }
        boolean notTake = helper2(nums, idx-1, target);
        boolean take = false;
        if(nums[idx]<target){
            take = helper2(nums, idx-1, target-nums[idx]);
        }
        return take || notTake;
    }
}