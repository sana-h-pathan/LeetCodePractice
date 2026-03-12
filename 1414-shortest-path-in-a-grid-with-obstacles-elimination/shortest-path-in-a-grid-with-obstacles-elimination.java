class Solution {
    int m;
    int n;
    int[][] dirs;

    public int shortestPath(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        if(k >= m + n - 2){
            return m + n - 2;
        }

        Queue<int[]> bfsQue = new LinkedList<>();
        int[][] visited = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(visited[i], -1);
        }

        bfsQue.add(new int[]{0, 0, k});
        visited[0][0] = k;

        int steps = 0;

        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();

            for(int s = 0; s < size; s++){
                int[] curr = bfsQue.remove();
                int i = curr[0];
                int j = curr[1];
                int remainingK = curr[2];

                if(i == m - 1 && j == n - 1){
                    return steps;
                }

                for(int[] dir : dirs){
                    int nr = i + dir[0];
                    int nc = j + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                        int newK = remainingK - grid[nr][nc];

                        if(newK >= 0 && visited[nr][nc] < newK){
                            visited[nr][nc] = newK;
                            bfsQue.add(new int[]{nr, nc, newK});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}