class Solution {
    private int n, m;
    int[][] dirs;
    public int maxAreaOfIsland(int[][] grid) {
        this.dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int max = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if (grid[i][j] > 0) 
                    max = Math.max(max, dfs(i, j, grid));
            }
        }
        return max;
    }
    private int bfs(int i, int j, int[][] grid){
        Queue<int[]> bfsQueue=new LinkedList<>();
        grid[i][j]=0;
        bfsQueue.add(new int[]{i,j});
        int sum=1;
        while(!bfsQueue.isEmpty()){
            int[] cords=bfsQueue.poll();
            for(int[]dir : dirs){
                int nr=cords[0]+dir[0];
                int nc=cords[1]+dir[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc]=0;
                    sum+=1;
                    bfsQueue.add(new int[]{nr,nc});
                }
            }
        }
        return sum;
    }
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] < 1) 
            return 0;
        grid[i][j] = 0;
        int sum=1;
        for(int[] dir: dirs){
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            sum+=dfs(nr, nc, grid);
        }
        return sum;
    }
}