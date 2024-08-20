class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int totalIsland=0;
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> bfsQue=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfsQue.add(new int[]{i,j});
                    totalIsland++;
                    visited[i][j]=true;
                    while(!bfsQue.isEmpty()){
                        int[] curr=bfsQue.poll();
                        for(int[] dir: dirs){
                            int nr=curr[0]+dir[0];
                            int nc=curr[1]+dir[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1' && !visited[nr][nc]){
                                bfsQue.add(new int[]{nr,nc});
                                visited[nr][nc]=true;
                            }
                            
                        }
                    }
                }
            }
        }
        return totalIsland;
    }
}