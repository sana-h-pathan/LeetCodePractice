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
        return helper1(nums, nums.length-1, target, dp);
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