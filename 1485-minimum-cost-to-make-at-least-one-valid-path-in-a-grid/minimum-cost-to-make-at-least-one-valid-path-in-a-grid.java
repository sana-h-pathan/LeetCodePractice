class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] mCost = new int[m][n];
        for(int[] row: mCost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        deque.addFirst(new int[]{0,0});
        mCost[0][0]=0;
        while(!deque.isEmpty()){
            int[] curr = deque.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i =0;i<dirs.length;i++){
                int nr = dirs[i][0]+r;
                int nc = dirs[i][1]+c;
                int cost = 0;
                if(grid[r][c]!=i+1){
                    cost = 1;
                }
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(mCost[r][c]+cost<mCost[nr][nc]){
                        mCost[nr][nc] = mCost[r][c]+cost;

                        if(cost==0){
                            deque.addFirst(new int[]{nr, nc});
                        } else {
                            deque.addLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return mCost[m-1][n-1];
    }
}