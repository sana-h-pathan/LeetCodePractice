class Solution {
    int m;
    int n;
    int[][] dirs;
    public int maxAreaOfIsland(int[][] grid) {
        this.m=grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, helper(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    private int helper(int[][] grid, int i, int j){
        int count=0;
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{i,j});
        grid[i][j]=0;
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            count++;
            for(int[] dir: dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                    bfsQue.add(new int[]{nr, nc});
                    grid[nr][nc]=0;
                }
            }
        }
        return count;
    }
}