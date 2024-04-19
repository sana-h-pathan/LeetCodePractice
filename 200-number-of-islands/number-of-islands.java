class Solution {
    int[][] dirs;
    int m;
    int n;
    public int numIslandsBFS(char[][] grid) {
        dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        m=grid.length;
        n=grid[0].length;
        int result=0;
        Queue<int []> bfsQue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    bfsQue.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!bfsQue.isEmpty()){
                        int[] curr=bfsQue.poll();
                        for(int[] dir: dirs){
                            int nr=dir[0]+curr[0];
                            int nc=dir[1]+curr[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                                grid[nr][nc]=0;
                                bfsQue.add(new int[] {nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public int numIslands(char[][] grid) {
        dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        m=grid.length;
        n=grid[0].length;
        int count=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        //base case
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0')
            return;
        //logic
        grid[i][j]='0';
        for(int [] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            dfs(grid, nr, nc);
        }
    }
}