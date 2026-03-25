class Solution {
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='2';
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j){
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{i,j});
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            for(int[] dir: dirs){
                int nr = dir[0]+curr[0];
                int nc = dir[1]+curr[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                    grid[nr][nc]='2';
                    bfsQue.add(new int[]{nr, nc});
                }
            }
        }
    }
}