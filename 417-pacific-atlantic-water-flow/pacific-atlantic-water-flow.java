class Solution {
    int m;
    int n;
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result=new ArrayList<>();
        this.m=heights.length;
        this.n=heights[0].length;
        boolean[][] pVisited=new boolean[m][n];
        boolean[][] aVisited=new boolean[m][n];
        for(int j=0;j<n;j++){
            dfs(heights,0,j,pVisited,heights[0][j]);
            dfs(heights,m-1,j,aVisited,heights[m-1][j]);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pVisited,heights[i][0]);
            dfs(heights,i,n-1,aVisited,heights[i][n-1]);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pVisited[i][j]==true && aVisited[i][j]==true){
                    List<Integer> innerList=new ArrayList<>();
                    innerList.add(i);
                    innerList.add(j);
                    result.add(innerList);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights,int r, int c,boolean[][] visited, int prevHeight){
        if(visited[r][c]) 
            return; 
        visited[r][c]=true;
        for(int[] dir:dirs){
            int nr=dir[0]+r;
            int nc=dir[1]+c;
            if(nr>=0 && nc>=0 && nr<m && nc<n && heights[nr][nc]>=prevHeight){
                dfs(heights, nr, nc, visited, heights[nr][nc]);
            }
        }
    }
}