class Solution {
    int n;
    int[][] dirs;
    public int shortestBridge(int[][] grid) {
        this.n = grid.length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        boolean found=false;
        Queue<int[]> bfsQue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!found && grid[i][j]==1){
                    helper(grid, i, j, bfsQue);
                    grid[i][j]=2;
                    found=true;
                }
            }
        }
        int gap=0;
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            for(int i=0;i<size;i++){
                int[] curr = bfsQue.poll();
                for(int[] dir: dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]!=2){
                        if(grid[nr][nc]==1){
                            return gap;
                        }
                        bfsQue.add(new int[]{nr, nc});
                        grid[nr][nc]=2;
                    }
                }
            }
            gap++;
        }
        return gap;
    }
    private void helper(int[][] grid, int i, int j, Queue<int[]> bfsQue){
        bfsQue.add(new int[]{i,j});
        for(int[] dir: dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                grid[nr][nc]=2;
                helper(grid, nr, nc, bfsQue);
            }
        }
    }
}