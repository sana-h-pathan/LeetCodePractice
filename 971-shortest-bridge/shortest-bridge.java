class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> bfsQue = new LinkedList<>(); 
        

        // 1) DFS to find and mark the first island
        boolean found = false;
        for (int r = 0; r < n && !found; r++) {
            for (int c = 0; c < n && !found; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, visited, bfsQue);
                    found = true;
                }
            }
        }

        // 2) BFS to expand until reaching the second island
        int steps = 0;
        while (!bfsQue.isEmpty()) {
            int size = bfsQue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = bfsQue.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if(visited[nr][nc]){
                            continue;
                        } 

                        // reached second island
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }
                        // expand into water
                        visited[nr][nc] = true;
                        bfsQue.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1; // guaranteed not to happen
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited, Queue<int[]> bfsQue) {
        int n = grid.length;
        if (r >= 0 && c >= 0 && r < n && c < n) {
            if (visited[r][c]) 
                return;
            if (grid[r][c] != 1) 
                return;

            visited[r][c] = true;
            bfsQue.offer(new int[]{r, c}); // add island cell as BFS source

            for (int[] dir : dirs) {
                int nr = r+dir[0];
                int nc = c+dir[1];
                dfs(grid,nr, nc, visited, bfsQue);
            }
        }
    }

}
