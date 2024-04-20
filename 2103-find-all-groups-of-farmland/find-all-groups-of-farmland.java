class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int x, y;
    int m;
    int n;

    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        m=land.length;
        n=land[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    x = 0; 
                    y = 0;
                    dfs(land, i,j);
                    int[] arr = new int[] {i, j, x, y};
                    result.add(arr);
                }
            }
        }
        
        return result.stream().toArray(int[][] :: new);
    }
    
    private void dfs(int[][] land, int r, int c) {
        land[r][c] = 3;
        x = Math.max(x, r); 
        y = Math.max(y, c);
        
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && land[nr][nc] == 1)
                dfs(land, nr, nc);
        }
    }
    
    
}