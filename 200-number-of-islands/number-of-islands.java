class Solution {
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int islandCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    islandCount++;
                    helper(grid,i, j);
                }
            }
        }
        return islandCount;
    }
    private void helper(char[][] grid, int i, int j){
        grid[i][j]='0';
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                helper(grid, nr, nc);
            }
        }
    }
}