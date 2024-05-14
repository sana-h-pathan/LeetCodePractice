class Solution {
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m;
    int n;
    int result=0;
    public int getMaximumGold(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] != 0) 
                    result=Math.max(result,dfs(grid,i,j));
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r==m || c==n||grid[r][c]==0 )
            return 0;
        int val=grid[r][c];
        int temp=grid[r][c];
        grid[r][c]=0;
        for(int[] dir: dirs){
            int nr=dir[0]+r;
            int nc=dir[1]+c;
            val = Math.max(val, temp + dfs(grid, nr, nc));
        }
        grid[r][c]=temp;
        return val;
    }
}