class Solution {
    int n;
    int[][] dirs;
    public int shortestBridge(int[][] grid) {
        this.n = grid.length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> bfsQue = new LinkedList<>();
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!found && grid[i][j]==1){
                    grid[i][j]=2;
                    found=true;
                    helper(grid, i, j, bfsQue);
                }
            }
        }
        int gap=0;
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            for(int i=0;i<size;i++){
                int[] curr = bfsQue.poll();
                for(int[] dir: dirs){
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
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
        bfsQue.add(new int[]{i, j});
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                grid[nr][nc]=2;
                helper(grid, nr, nc, bfsQue);
            }
        }
    }
}