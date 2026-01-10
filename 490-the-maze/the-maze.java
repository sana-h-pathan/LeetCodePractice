class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> bfsQue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        bfsQue.add(start);
        maze[start[0]][start[1]]=2;
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            for(int[] dir: dirs){
                int nr = dir[0]+curr[0];
                int nc = dir[1]+curr[1];
                while(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]!=1){
                    nr+=dir[0];
                    nc+=dir[1];
                }
                nr-=dir[0];
                nc-=dir[1];
                if(maze[nr][nc]!=2){
                    if(nr==destination[0] && nc==destination[1]){
                        return true;
                    }
                    bfsQue.add(new int[]{nr, nc});
                    maze[nr][nc]=2;
                }
            }
        }
        return false;
    }
}