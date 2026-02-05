class Solution {
    int[][] dirs;
    int m;
    int n;
    public void wallsAndGates(int[][] rooms) {
        this.m = rooms.length;
        this.n = rooms[0].length;
        this.dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0)
                    dfs(rooms,i, j, 0);
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int distance) {
        if(rooms[i][j]<=distance && distance!=0) 
            return;
		// Set the cell to closest distance
        rooms[i][j] = distance;
        for(int[] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && rooms[nr][nc]!=-1) 
                dfs(rooms, nr, nc, distance+1);
        }
    }
}