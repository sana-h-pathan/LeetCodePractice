class Solution {
    int[][] dirs;
    int m;
    int n;
    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int result = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result = Math.max(result, helper(grid, i, j));
            }
        }
        return result;
    }

    private int helper(int[][] grid, int i, int j){
        int currGold = grid[i][j];
        grid[i][j]=0;
        int best=0;
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]!=0){
                best = Math.max(best, helper(grid, nr, nc));
            }
        }
        grid[i][j]=currGold;
        return best+currGold;
    }
}