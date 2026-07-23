class Solution {
    int m;
    int n;
    int[][] dirs;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        this.m = heights.length;
        this.n = heights[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] aVisited = new boolean[m][n];
        boolean[][] pVisited = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(heights, i, 0, pVisited);
            dfs(heights, i, n-1, aVisited);
        }
        for(int j=0;j<n;j++){
            dfs(heights, 0, j, pVisited);
            dfs(heights, m-1, j, aVisited);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(aVisited[i][j] && pVisited[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited){
        if(visited[i][j]){
            return;
        }
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{i,j});
        visited[i][j] = true;
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir: dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && heights[nr][nc]>=heights[r][c]){
                    visited[nr][nc]= true;
                    bfsQue.add(new int[]{nr, nc});
                }
            }
        }
    }
}