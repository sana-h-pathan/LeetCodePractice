class Solution {
    int m;
    int n;
    int[][] dirs;
    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int currArea = helper(grid, i, j);
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        return maxArea;
    }
    private int helper(int[][] grid, int i, int j){
        int islandArea = 1;
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{i,j});
        grid[i][j]=0;
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            for(int[] dir: dirs){
                int nr = dir[0]+curr[0];
                int nc = dir[1]+curr[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                    islandArea++;
                    bfsQue.add(new int[]{nr, nc});
                    grid[nr][nc]=0;
                }
            }
        }
        return islandArea;
    }
}