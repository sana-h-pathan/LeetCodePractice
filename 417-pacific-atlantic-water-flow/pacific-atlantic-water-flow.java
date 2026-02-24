class Solution {
    int m;
    int n;
    int[][] dirs;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        this.m = heights.length;
        this.n = heights[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] pVisted = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(heights, i, 0, pVisted, heights[i][0]);
            dfs(heights, i, n-1, aVisited, heights[i][n-1]);
        }
        for(int j=0;j<n;j++){
            dfs(heights, 0, j, pVisted, heights[0][j]);
            dfs(heights, m-1, j, aVisited, heights[m-1][j]);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(aVisited[i][j] && pVisted[i][j]){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(i);
                    subList.add(j);
                    result.add(subList);
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int prevHeight){
        if(visited[i][j]){
            return;
        }
        visited[i][j]=true;
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if(nr>=0 && nc>=0 && nr<m && nc<n && heights[nr][nc]>=prevHeight){
                dfs(heights, nr, nc, visited,  heights[nr][nc]);
            }
        }
    }
}
