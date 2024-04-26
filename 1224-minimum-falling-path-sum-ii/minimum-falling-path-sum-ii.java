class Solution {
    int n;
    public int minFallingPathSum(int[][] grid) {
        this.n=grid.length;
        int result=Integer.MAX_VALUE;
        int[] prevDP=new int[n];
        int[] dp=new int[n];
        for(int c=0;c<n;c++){
            prevDP[c]=grid[0][c];
        }
        for(int r=1;r<n;r++){
            Arrays.fill(dp, Integer.MAX_VALUE);
            for(int cc=0;cc<n;cc++){
                for(int pc=0;pc<n;pc++){
                    if(pc!=cc){
                        dp[cc]=Math.min(dp[cc], grid[r][cc]+prevDP[pc]);
                    }
                }
            }
            System.arraycopy(dp, 0, prevDP, 0, n);
        }
        for(int num: prevDP){
            result=Math.min(result, num);
        }
        return result;
    }
}