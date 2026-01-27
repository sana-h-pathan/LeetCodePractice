class Solution {
    // Direction vectors: right, left, down, up (matching grid values 1,2,3,4)
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Track minimum cost to reach each cell
        int[][] minCost = new int[m][n];
        for (int[] i : minCost) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        // Use deque for 0-1 BFS - add zero cost moves to front, cost=1 to back
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});
        minCost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            // Try all four directions
            for (int d=0;d<4;d++) {
                int nr = curr[0] + dirs[d][0];
                int nc = curr[1] + dirs[d][1];
                int cost = (grid[curr[0]][curr[1]]!=(d+1))?1:0;

                // If position is valid and we found a better path
                if (nr>=0 && nc>=0 && nr<m && nc<n){
                    if(minCost[curr[0]][curr[1]]+cost<minCost[nr][nc]){
                        minCost[nr][nc] = minCost[curr[0]][curr[1]]+cost;
                        // Add to back if cost=1, front if cost=0
                        if (cost==1){
                            deque.offerLast(new int[]{nr,nc});
                        } else {
                            deque.offerFirst(new int[]{nr,nc});
                        }
                    }
                }
            }
        }
        return minCost[m-1][n-1];
    }
}