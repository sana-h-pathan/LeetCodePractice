class Solution {

    int m;
    int n;
    int[][] dirs;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        this.dirs = new int[][]{ {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> bfsQue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        bfsQue.add(new int[]{0,0});
        visited[0][0] = true;

        int steps = 0;

        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            steps++;
            for(int i = 0; i < size; i++){
                int[] curr = bfsQue.remove();
                int r = curr[0];
                int c = curr[1];
                if(r == m-1 && c == n-1){
                    return steps;
                }
                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && grid[nr][nc] == 0){
                        visited[nr][nc] = true;
                        bfsQue.add(new int[]{nr,nc});
                    }
                }
            }
        }

        return -1;
    }
}