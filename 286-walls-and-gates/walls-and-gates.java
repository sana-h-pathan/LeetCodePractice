class Solution {
    int[][] dirs;
    public void wallsAndGates(int[][] rooms) {
        this.dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0)
                    dfs(rooms,i, j, 0);
            }
        }
    }

    public void dfs(int[][] rooms, int row, int col, int distance) {
		if(row >= rooms.length || row<0 || col >=rooms[0].length || col<0 || rooms[row][col] == -1) 
            return;
        if(rooms[row][col]<=distance && distance !=0) 
            return;
		// Set the cell to closest distance
        rooms[row][col] = distance;
        for(int[] dir: dirs){
            int nr=row+dir[0];
            int nc=col+dir[1];
            dfs(rooms, nr, nc, distance+1);
        }
    }
}