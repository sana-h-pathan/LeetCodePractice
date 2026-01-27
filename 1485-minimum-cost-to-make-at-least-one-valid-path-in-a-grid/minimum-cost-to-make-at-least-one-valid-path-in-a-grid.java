class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] minCost = new int[m][n];
        for(int[] r : minCost){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        deque.offerFirst(new int[]{0,0});
        minCost[0][0]=0;
        while(!deque.isEmpty()){
            int[] curr = deque.pollFirst();
            for(int i=0;i<dirs.length;i++){
                int nr = dirs[i][0]+curr[0];
                int nc = dirs[i][1]+curr[1];
                int cost=0;
                if(grid[curr[0]][curr[1]]!=i+1){
                    cost=1;
                }
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(minCost[curr[0]][curr[1]]+cost<minCost[nr][nc]){
                        minCost[nr][nc]= minCost[curr[0]][curr[1]]+cost;
                        if(cost==0){
                            deque.offerFirst(new int[]{nr,nc});
                        } else {
                            deque.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return minCost[m-1][n-1];
    }
}