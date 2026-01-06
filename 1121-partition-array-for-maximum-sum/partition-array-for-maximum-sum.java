class Solution {
    int n;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(arr, k, 0, dp);
        
    }
    private int helper(int[] nums, int k, int idx, int[] dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int currLen = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxTotal = Integer.MIN_VALUE;
        for(int i=idx;i<Math.min(idx+k,n);i++){
            currLen++;
            maxVal = Math.max(nums[i], maxVal);
            int currSum = maxVal*currLen + helper(nums, k, i+1,dp);
            maxTotal = Math.max(maxTotal, currSum);
        }
        
        return dp[idx] = maxTotal;
    }
    public int maxSumAfterPartitioning1(int[] arr, int k) {
        this.n = arr.length;
        return helper(arr, k, 0);
        
    }
    private int helper(int[] nums, int k, int idx){
        if(idx==nums.length){
            return 0;
        }
        int currLen = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxTotal = Integer.MIN_VALUE;
        for(int i=idx;i<Math.min(idx+k,n);i++){
            currLen++;
            maxVal = Math.max(nums[i], maxVal);
            int currSum = maxVal*currLen + helper(nums, k, i+1);
            maxTotal = Math.max(maxTotal, currSum);
        }
        return maxTotal;
    }
}