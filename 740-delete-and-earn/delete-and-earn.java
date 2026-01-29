class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num: nums)
            max=Math.max(max, num);
        
        int[] temp=new int[max+1];
        for(int num: nums){
            temp[num]+=num;
        }
        int[] dp=new int[max+1];
        dp[0]=temp[0];
        dp[1]=Integer.max(dp[0],temp[1]);
        for(int i=2;i<=max;i++){
            dp[i]=Integer.max(dp[i-1],dp[i-2]+temp[i]);
        }
        return Integer.max(dp[max-1],dp[max]); 
    }
    public int deleteAndEarn2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] temp = new int[max + 1];
        for (int num : nums) {
            temp[num] += num;
        }

        Integer[] memo = new Integer[max + 1];
        return dfs(max, temp, memo);
    }

    private int dfs(int i, int[] temp, Integer[] memo) {
        if (i == 0) 
            return temp[0];
        if (i == 1) 
            return Math.max(temp[0], temp[1]);

        if (memo[i] != null) 
            return memo[i];

        memo[i] = Math.max(
            dfs(i - 1, temp, memo),
            dfs(i - 2, temp, memo) + temp[i]
        );

        return memo[i];
    }

}