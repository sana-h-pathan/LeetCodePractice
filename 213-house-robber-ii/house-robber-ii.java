class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        int first = helper(nums, 0, n-1);
        int second = helper(nums, 1, n);

        return Math.max(first, second);
    }
    private int helper(int [] nums, int start, int end){
        int n = end-start;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start+1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[start+i]);
        }
        return dp[n-1];
    }
}