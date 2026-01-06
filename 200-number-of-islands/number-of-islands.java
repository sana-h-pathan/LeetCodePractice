class Solution {
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][]visited = new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    visited[i][j]=true;
                    islands++;
                    helper(grid, i, j, visited);
                }
            }
        }
        return islands;
    }

    private void helper(char[][] grid, int i, int j, boolean[][] visited){
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{i,j});
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            for(int[] dir: dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1' && !visited[nr][nc]){
                    bfsQue.add(new int[]{nr, nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }
}