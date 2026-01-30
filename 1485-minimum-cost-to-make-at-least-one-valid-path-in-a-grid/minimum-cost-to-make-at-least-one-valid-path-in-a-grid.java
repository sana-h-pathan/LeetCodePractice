class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] minCost = new int[m][n];
        for(int[] row: minCost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dq.offerFirst(new int[]{0,0});
        minCost[0][0]=0;

        while(!dq.isEmpty()){
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<dirs.length;i++){
                int nr = r+dirs[i][0];
                int nc = c+dirs[i][1];
                int cost=0;
                if(grid[r][c]!=i+1){
                    cost=1;
                }
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(minCost[r][c]+cost<minCost[nr][nc]){
                        minCost[nr][nc] = minCost[r][c]+cost;

                        if(cost==0){
                            dq.offerFirst(new int[]{nr,nc});
                        } else {
                            dq.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return minCost[m-1][n-1];
    }
}