class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        this.m=maze.length;
        this.n=maze[0].length;
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        Queue<int[]> bfsQueue=new LinkedList<>();
        bfsQueue.add(start);
        maze[start[0]][start[1]]=2;
        while (!bfsQueue.isEmpty()){
            int[] curr=bfsQueue.poll();
            for(int[] dir: dirs){
                int cr=curr[0];
                int cc=curr[1];
                while(cr>=0 && cc>=0 && cr<m && cc<n && maze[cr][cc]!=1){
                    cr+=dir[0];
                    cc+=dir[1];
                }
                cr-=dir[0];
                cc-=dir[1];
                if(maze[cr][cc]!=2){
                    if(cr==destination[0] && cc==destination[1])
                        return true;
                    bfsQueue.add(new int[]{cr,cc});
                    maze[cr][cc]=2;
                }
            }
        }
        return false;
    }
}